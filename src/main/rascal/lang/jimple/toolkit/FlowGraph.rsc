module lang::jimple::toolkit::FlowGraph


import lang::jimple::core::Syntax;

import Relation;
import analysis::graphs::Graph;


alias FlowGraph = Graph[Node]; 

data Node = entryNode()
          | exitNode()
          | skipNode()
          | stmtNode(Statement s)
          ;

public FlowGraph empty() = {}; 

public FlowGraph forwardFlowGraph(MethodBody body) {
  switch(body) {
    case methodBody(_, stmts, _): return buildGraph(mapLabels(stmts), stmts, entryNode(), {}); 
  }
  return empty();
}

public FlowGraph backwardFlowGraph(MethodBody body) = invert(forwardFlowGraph(body));

private FlowGraph buildGraph(map[Label, Statement] labels, list[Statement] stmts, Node current, FlowGraph g) {
  FlowGraph res = empty();  
  switch(stmts) {
    case [] : res = <current, exitNode()> + g;
    case [label(str _), *NS] : res = buildGraph(labels, [*NS], current, g);
    case [gotoStmt(str l), *NS]: { 
      newNode = stmtNode(gotoStmt(l));
      target = stmtNode(labels[l]);  
      
      g = <current, newNode> + g;
      g = <newNode, target>  + g;  
      
      res = buildGraph(labels, [*NS], skipNode(), g);
    }
    case [ifStmt(Expression e, Label l), *NS]: { 
      newNode = stmtNode(ifStmt(e, l));
      target = stmtNode(labels[l]); 
      
      g = <current, newNode> +  g; 
      g = <newNode, target>  +  g;
        
      res = buildGraph(labels, [*NS], newNode, g);   
    }
    case [N, *NS] : res = buildGraph(labels, [*NS], stmtNode(N), (<current, stmtNode(N)> + g));
  }
  return { <from, to> | <from, to> <- res, from != skipNode() } ;
} 

public map[Label, Statement] mapLabels(list[Statement] stmts) { 
  map[Label, Statement] res = (); 
  switch(stmts) {
    case [] : res = (); 
    case [label(Label l), S, *SS] :  res = (l:S) + mapLabels(SS);
    case [_, *SS] : res = mapLabels(SS);
  }
  return res;
}
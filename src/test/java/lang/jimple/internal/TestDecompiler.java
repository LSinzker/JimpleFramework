package lang.jimple.internal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import io.usethesource.vallang.IConstructor;
import io.usethesource.vallang.IValueFactory;
import io.usethesource.vallang.impl.persistent.ValueFactory;

public class TestDecompiler {
	
	@Test 
	public void decompileInterface() {
		try {
			File classFile = new File("./target/test-classes/samples/InterfaceSample.class"); 
			assertNotNull(classFile);
			
			IValueFactory vf = ValueFactory.getInstance();
			Decompiler decompiler = new Decompiler(vf);
			IConstructor c = decompiler.decompile(new FileInputStream(classFile), null);
			
			assertNotNull(c);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test 
	public void decompileAutoIncrementClass() {
		try {
			File classFile = new File("./target/test-classes/samples/AutoIncrementSample.class"); 
			assertNotNull(classFile);
			
			IValueFactory vf = ValueFactory.getInstance();
			Decompiler decompiler = new Decompiler(vf);
			IConstructor c = decompiler.decompile(new FileInputStream(classFile), null);
			
			assertNotNull(c);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test 
	public void decompileWhileStmtSampleClass() {
		try {
			File classFile = new File("./target/test-classes/samples/WhileStmtSample.class"); 
			assertNotNull(classFile);
			
			IValueFactory vf = ValueFactory.getInstance();
			Decompiler decompiler = new Decompiler(vf);
			IConstructor c = decompiler.decompile(new FileInputStream(classFile), null);
			
			
			assertNotNull(c);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test 
	public void decompileSlf4JMDCClass() {
		try {
			File classFile = new File("./target/test-classes/slf4j/org/slf4j/MDC.class"); 
			assertNotNull(classFile);
			
			IValueFactory vf = ValueFactory.getInstance();
			Decompiler decompiler = new Decompiler(vf);
			IConstructor c = decompiler.decompile(new FileInputStream(classFile), null);
			
			assertNotNull(c);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test 
	public void decompileNestedInterface() {
		try {
			File classFile = new File("./target/test-classes/samples/NestedInterface.class"); 			
			assertNotNull(classFile);
			
			IValueFactory vf = ValueFactory.getInstance();
			Decompiler decompiler = new Decompiler(vf);
			IConstructor c = decompiler.decompile(new FileInputStream(classFile), null);
			
			assertNotNull(c);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	

}

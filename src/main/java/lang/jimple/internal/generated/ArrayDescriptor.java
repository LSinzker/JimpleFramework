package lang.jimple.internal.generated;

import lang.jimple.internal.JimpleAbstractDataType;
import lombok.*;

import io.usethesource.vallang.IConstructor;
import io.usethesource.vallang.IValue;
import io.usethesource.vallang.IValueFactory;

@EqualsAndHashCode
public abstract class ArrayDescriptor extends JimpleAbstractDataType {
	@Override
	public String getBaseType() {
		return "ArrayDescriptor";
	}

	public static ArrayDescriptor fixedSize(Integer size) {
		return new c_fixedSize(size);
	}

	public static ArrayDescriptor variableSize() {
		return new c_variableSize();
	}

	@EqualsAndHashCode
	public static class c_fixedSize extends ArrayDescriptor {

		public Integer size;

		public c_fixedSize(Integer size) {

			this.size = size;

		}

		@Override
		public IConstructor createVallangInstance(IValueFactory vf) {

			IValue iv_size = vf.integer(size);

			return vf.constructor(getVallangConstructor()

					, iv_size

			);
		}

		@Override
		public String getConstructor() {
			return "fixedSize";
		}
	}

	@EqualsAndHashCode
	public static class c_variableSize extends ArrayDescriptor {

		public c_variableSize() {

		}

		@Override
		public IConstructor createVallangInstance(IValueFactory vf) {

			return vf.constructor(getVallangConstructor()

			);
		}

		@Override
		public String getConstructor() {
			return "variableSize";
		}
	}

}
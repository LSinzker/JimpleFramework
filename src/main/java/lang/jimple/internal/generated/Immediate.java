package lang.jimple.internal.generated;

import lang.jimple.internal.JimpleAbstractDataType;
import lombok.*;

import io.usethesource.vallang.IConstructor;
import io.usethesource.vallang.IValue;
import io.usethesource.vallang.IValueFactory;

@EqualsAndHashCode
public abstract class Immediate extends JimpleAbstractDataType {
	@Override
	public String getBaseType() {
		return "Immediate";
	}

	public static Immediate local(String localName) {
		return new c_local(localName);
	}

	public static Immediate iValue(Value v) {
		return new c_iValue(v);
	}

	public static Immediate caughtException() {
		return new c_caughtException();
	}

	@EqualsAndHashCode
	public static class c_local extends Immediate {

		public String localName;

		public c_local(String localName) {

			this.localName = localName;

		}

		@Override
		public IConstructor createVallangInstance(IValueFactory vf) {

			IValue iv_localName = vf.string(localName);

			return vf.constructor(getVallangConstructor()

					, iv_localName

			);
		}

		@Override
		public String getConstructor() {
			return "local";
		}
	}

	@EqualsAndHashCode
	public static class c_iValue extends Immediate {

		public Value v;

		public c_iValue(Value v) {

			this.v = v;

		}

		@Override
		public IConstructor createVallangInstance(IValueFactory vf) {

			IValue iv_v = v.createVallangInstance(vf);

			return vf.constructor(getVallangConstructor()

					, iv_v

			);
		}

		@Override
		public String getConstructor() {
			return "iValue";
		}
	}

	@EqualsAndHashCode
	public static class c_caughtException extends Immediate {

		public c_caughtException() {

		}

		@Override
		public IConstructor createVallangInstance(IValueFactory vf) {

			return vf.constructor(getVallangConstructor()

			);
		}

		@Override
		public String getConstructor() {
			return "caughtException";
		}
	}

}
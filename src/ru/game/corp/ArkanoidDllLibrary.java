package ru.game.corp;

import com.ochafik.lang.jnaerator.runtime.LibraryExtractor;
import com.ochafik.lang.jnaerator.runtime.Structure;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
/**
 * JNA Wrapper for library <b>ArkanoidDll</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public interface ArkanoidDllLibrary extends Library {
	public static final java.lang.String JNA_LIBRARY_NAME = LibraryExtractor.getLibraryPath("e:\\projs\\workspace_helios\\Arkanoid\\src\\ru\\game\\corp\\netgame.dll", true, ArkanoidDllLibrary.class);
	public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(ArkanoidDllLibrary.JNA_LIBRARY_NAME, com.ochafik.lang.jnaerator.runtime.MangledFunctionMapper.DEFAULT_OPTIONS);
	public static final ArkanoidDllLibrary INSTANCE = (ArkanoidDllLibrary)Native.loadLibrary(ArkanoidDllLibrary.JNA_LIBRARY_NAME, ArkanoidDllLibrary.class, com.ochafik.lang.jnaerator.runtime.MangledFunctionMapper.DEFAULT_OPTIONS);
	public static class Man extends Structure<Man, Man.ByValue, Man.ByReference > {
		public Pointer name;
		public int bit_X;
		public int ball_X;
		public int ball_Y;
		public int status;
		public Man() {
			super();
		}
		public Man(Pointer name, int bit_X, int ball_X, int ball_Y, int status) {
			super();
			this.name = name;
			this.bit_X = bit_X;
			this.ball_X = ball_X;
			this.ball_Y = ball_Y;
			this.status = status;
		}
		protected ByReference newByReference() { return new ByReference(); }
		protected ByValue newByValue() { return new ByValue(); }
		protected Man newInstance() { return new Man(); }
		public static Man[] newArray(int arrayLength) {
			return Structure.newArray(Man.class, arrayLength);
		}
		public static class ByReference extends Man implements Structure.ByReference {
			
		};
		public static class ByValue extends Man implements Structure.ByValue {
			
		};
	};
	void TCPServer1Execute(ArkanoidDllLibrary.TIdPeerThread AThread);
	@java.lang.Deprecated 
	int net_open(Pointer ip, int port);
	int net_open(java.lang.String ip, int port);
	int net_close();
	int net_send(ArkanoidDllLibrary.Man.ByValue a);
	int net_getData();
	/// Pointer to unknown (opaque) type
	public static class TIdPeerThread extends PointerType {
		public TIdPeerThread(Pointer address) {
			super(address);
		}
		public TIdPeerThread() {
			super();
		}
	};
}

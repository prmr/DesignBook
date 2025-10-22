module designbook
{
	exports e1.chapter1;
	exports e1.chapter2;
	exports e1.chapter3;
	exports e1.chapter4;
	exports e1.chapter5;
	exports e1.chapter6;
	exports e1.chapter7;
	exports e1.chapter8;
	exports e1.chapter9;
	
	exports e2.chapter1;
	exports e2.chapter2;
	exports e2.chapter3;
	exports e2.chapter4;
	exports e2.chapter5;
	exports e2.chapter6;
	exports e2.chapter7;
	exports e2.chapter8;
	exports e2.chapter9;

	requires java.desktop;
	requires javafx.controls;
	requires transitive javafx.graphics;	
	requires static junit;
	requires static org.junit.jupiter.api;
	requires static org.junit.jupiter.params;
}
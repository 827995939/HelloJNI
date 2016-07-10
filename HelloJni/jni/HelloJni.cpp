#include "com_example_hellojni_ClientJni.h"
#include <stdlib.h>
#include <stdio.h>

#ifdef __cplusplus
extern "C" {
#endif
class CClass {
public:
	int Add(int a, int b);
};
int CClass::Add(int a, int b) {
	return a + b;
}
/*
 * Class:     com_example_hellojni_ClientJni
 * Method:    AddInt
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_example_hellojni_ClientJni_AddInt(JNIEnv *env,
		jobject obj, jint x, jint y){
CClass *Class=new CClass;
int aa=Class->Add(x,y);
return aa;

};

#ifdef __cplusplus
}
#endif

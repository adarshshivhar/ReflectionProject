package com.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.student.Student;

public class ReflectionDemo {

	public static void main(String[] args) {
		try {
			
			int count = 0;
			Class<?> classObj = Class.forName("com.student.Student");
			
			System.out.println("Package Information: ");
			
			Package packageObj = classObj.getPackage();
			
			System.out.println("Package Name = " + packageObj.getName());
			
			
			System.out.println("--------------------------------------");
			
			
			System.out.println("\nSuperClass Information: ");
			Class<?> superClass = classObj.getSuperclass();
			System.out.println(superClass);
			System.out.println("Name: " + superClass.getName());
			System.out.println("Simple Name: " +superClass.getSimpleName());
			
			System.out.println("----------------------------------------");
			
			System.out.println("\nList of Interface Implemented by Class:");
			Class[] interfaceArray = classObj.getInterfaces();
			if(interfaceArray.length == 0) {
				System.out.println("No Interface Implemented");
			} else {
				System.out.println("No. of Interface Implemented: "+ interfaceArray.length);
				for(Class interfaceName: interfaceArray) {
					System.out.println(interfaceName);
					System.out.println("Name: "+ interfaceName.getSimpleName());
				}
			}
			
			System.out.println("----------------------------------------");
		    System.out.println("Annotation: ");
		    Annotation[] annotationArray = classObj.getAnnotations();
		    if(annotationArray.length == 0) {
		    	System.out.println("No Annotations");
		    }else {
		    	for(Annotation annotation: annotationArray) {
		    		System.out.println("No. of Annotations: "+ annotationArray.length);
		    		System.out.println(annotation);
		    	}
		    }
			
			System.out.println("----------------------------------------");
			System.out.println("\nFields: ");
			
			Field[] fieldArray = classObj.getDeclaredFields();
			System.out.println("No of Fields: "+ fieldArray.length);
			for(Field field: fieldArray) {
				System.out.println("Name: " + field.getName()+"||"+"Field Type: "+ field.getType());
			}
					
			System.out.println("-------------------------------------");
			
			System.out.println("\nConstructors: ");
			
			Constructor<?>[] constructorArray = classObj.getDeclaredConstructors();
			System.out.println("No. of constructors: " + constructorArray.length);
			for(Constructor<?> constructor : constructorArray) {
				System.out.println("Name: "+constructor +" || "+"No. of Parameters: "+constructor.getParameterCount());
			}
			
			System.out.println("--------------------------------------");
			
			System.out.println("\nMethods: ");
			
			Method[] methodArray = classObj.getDeclaredMethods();
			System.out.println("No. of Methods: "+ methodArray.length);
			System.out.println("\nGetter Method: ");
			for(Method method: methodArray) {
				if (isGetter(method)) {
					System.out.println(++count +".)" + method + "  " + "Parameters count:" + method.getParameterCount());
				}
			}
			
			System.out.println("\nSetter Method: ");
			count = 0;
			for(Method method: methodArray) {
				if (isSetter(method)) {
					System.out.println(++count +".)" + method + "  " + "Parameters count:" + method.getParameterCount());
					
				}
			}
			
			System.out.println("\nNormal Method: ");
			count = 0;
			for(Method method: methodArray) {
				if(!(isGetter(method) || isSetter(method))) {
					System.out.println(++count +".)" + method + "  " + "Parameters count:" + method.getParameterCount());
				}	
			}
			
			System.out.println("\nInvoke Private Method");

			Method privateGetNameMethod = classObj.getDeclaredMethod("fullName", null); 
			privateGetNameMethod.setAccessible(true);
			
			Student student = new Student(1, "Adarsh","Shivhare");
			System.out.println("Method Name: " + privateGetNameMethod.getName());
			String returnValue = (String) privateGetNameMethod.invoke(student, null);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get")) {
			return false;
		}

		if (method.getParameterTypes().length != 0) {
			return false;
		}
		
		if(void.class.equals(method.getReturnType())) {
			return false;
		}
			return true;
	}

	private static boolean isSetter(Method method) {
		if(!method.getName().startsWith("set")) {
			return false;
		}
		
		if(method.getParameterTypes().length != 1) {
			return false;
		}
		return true;
	}

}

package Lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        SimpleObject simpleObject=new SimpleObject("objectTest",1922);
        try {
            callMethodAnnot(simpleObject);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void callMethodAnnot(Object object) throws InvocationTargetException, IllegalAccessException {
        Class c = object.getClass();
        for (Method m:c.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Annotation.class)) {
                if (Modifier.isProtected(m.getModifiers()) | Modifier.isPrivate(m.getModifiers())) {
                    m.setAccessible(true);
                    for (int i = 0; i < m.getAnnotation(Annotation.class).value(); i++) {
                        Class<?>[] paramType = m.getParameterTypes();
                        Object[] args = null;
                        try {
                            args = getArgs(paramType);
                            m.invoke(object, args);
                        } catch (InvalidParameter e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        };
    };

    private static Object[] getArgs(Class<?>[] paramType) throws InvalidParameter {
        Object[] args = new Object[paramType.length];
        for (int j = 0; j < paramType.length; j++) {
            if (paramType[j] == int.class) {
                args[j] = 1234;
            }
            else if (paramType[j] == short.class) {
                args[j] = 123;
            }
            else if (paramType[j] == byte.class) {
                args[j] = 12;
            }
            else if (paramType[j] == long.class) {
                args[j] = 123456L;
            }
            else if (paramType[j] == float.class) {
                args[j] = 123.0F;
            }
            else if (paramType[j] == double.class) {
                args[j] = 1234.0;
            }
            else if (paramType[j] == String.class) {
                args[j] = "new_string_parameter";
            }
            else if (paramType[j] == char.class) {
                args[j] = 's';
            }
            else if (paramType[j] == boolean.class) {
                args[j] = true;
            } else {
                throw new InvalidParameter("Unknown type in method: " + paramType[j]);
            };
        };
        return args;
    }
}


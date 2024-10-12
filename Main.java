package Lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
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
                        Object[] args = new Object[paramType.length];

                        for (int j = 0; j < m.getParameterTypes().length; j++) {
                            if (paramType[j] == String.class) {
                                args[j] = "new_string_parameter";
                            }
                            else if (paramType[j] == int.class) {
                                args[j] = 12345;
                            }
                            else {
                                args[j] = 0;
                            }
                        };
                        m.invoke(object, args);
                    }
                }
            };
        };
    };
}

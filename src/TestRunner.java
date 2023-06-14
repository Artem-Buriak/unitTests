import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestRunner {
    File file;
    public TestRunner() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String dateFileName = formatter.format(new Date());
        file = new File(dateFileName+"_test.txt");
    }

    //- для запуску тесту на ім'я класу (рядкове значення)
    public void runTestClassByName(String className) throws ClassNotFoundException {
        Result result = JUnitCore.runClasses(Class.forName(className));

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            FileManager.log(file, "error", "runTestClassByName");
        }

        if (result.wasSuccessful()) {
            System.out.println("runTestClassByName - All tests are OK");
            FileManager.log(file, "ok", "runTestClassByName");
        }
    }
    //- для запуску тесту на ім'я класу (тип даних клас)
    public void runTestClassByClass(Class<?> clazz) throws ClassNotFoundException {
        Result result = JUnitCore.runClasses(clazz);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            FileManager.log(file, "error", "runTestClassByClass");
        }

        if (result.wasSuccessful()) {
            System.out.println("runTestClassByClass - All tests are OK");
            FileManager.log(file, "ok", "runTestClassByClass");
        }
    }
    //імена класів (масив)
    public void runTestClassesByNames(String... classNames) throws ClassNotFoundException {
        List<String> classList = Arrays.asList(classNames);
        System.out.println("runTestClassesByNames - running...");
        for (int i = 0; i<classList.size();i++) {
            runTestClassByName(classList.get(i));
        }
    }
    //класи (масив)
    public void runTestClassByClasses(Class<?>... clazzes) throws ClassNotFoundException {
        List<Class<?>> classList = Arrays.asList(clazzes);
        System.out.println("runTestClassByClasses - running...");
        for (int i = 0; i<classList.size();i++) {
            runTestClassByClass(classList.get(i));
        }
    }
    //- для запуску тестів за розташуванням у пакеті (рядкове значення)
    public void runTestClassByDirectory(String classPath) throws ClassNotFoundException {
        System.out.println("runTestClassByDirectory - running...");
        String[] arr = classPath.split("/");
        String className = arr[arr.length-1];
        runTestClassByName(className);
    }
}

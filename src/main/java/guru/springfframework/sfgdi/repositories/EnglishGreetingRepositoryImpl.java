package guru.springfframework.sfgdi.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository{

    @Override
    public String getGreeting(){
        return "Hello World from REPO - EN";
    }
}

package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        //테스트코드를 위해서 코렉트픽스트제네레이터와 롱픽스드제너레이트를 만들어야함 우리가 조절으 못하기에
        //이것을 결합을 느슨하게한다라고 표현
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();
        if (password.length()>=8 && password.length()<=12){
            this.password= password;
        }


    }
    //getter
    public String getPassword() {
        return password;
    }

}

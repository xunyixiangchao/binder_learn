package com.lis.binder_learn;



import com.lis.binder_learn.Person;

interface Aidl{
        //客户端传输
        void addPerson(in Person person);

        List<Person> getPersonList();
}
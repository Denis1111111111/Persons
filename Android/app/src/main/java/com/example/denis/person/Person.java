package com.example.denis.person;

public class Person {
        public int Id;
        public String Fname;
        public String Lname;
        public int Age;

        public Person(int Id, String Fname, String Lname, int Age) {
            this.Id = Id;
            this.Fname = Fname;
            this.Lname = Lname;
            this.Age = Age;
        }

        public int getId() {
            return Id;
        }

        public String getFname() {
            return Fname;
        }

        public int getAge() {
            return Age;
        }

        public String getLname() {
            return Lname;
        }

        @Override
        public String toString() {
            return "Id=" + Id + " Fname=" + Fname + " Lname=" + Lname + " Age=" + Age;
        }
    }

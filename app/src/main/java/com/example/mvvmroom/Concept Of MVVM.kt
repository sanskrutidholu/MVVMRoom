package com.example.mvvmroom

// MVVM with Room Database ->

1. Entity = it is similar to normal model class.It use to create tables in database.
            Each property in the class represent column in table.

2. Dao = it is use to specify sql queries.It must be interface or abstract
         class.

3. Database = it uses dao to issues quires.

4. Repository = it manages queries. It mainly decide whether to fetch data
                from a network or use results cached in a local database.

5. ViewModel = it is use to show the queries for those data which are to be
               displayed in view, i.e recyclerview.
import sqlite3

conn = sqlite3.connect('pythonsqlassgn.db')
cursor = conn.cursor()

def create_table():
    cursor.execute('''CREATE TABLE IF NOT EXISTS employees(id INTEGER PRIMARY KEY,name TEXT,position TEXT,salary REAL)''')

def insert_record(id,name,position,salary):
    cursor.execute('''INSERT INTO employees (id,name,position,salary)
                   VALUES(?,?,?,?)''',(id,name,position,salary))
                   
    conn.commit()
    print(f"Record with ID={id} inserted successfully")

employee_id = 1
employee_name = 'pranush'
employee_position = 'analyst'
employee_salary =  50000.00

create_table()

insert_record(employee_id,employee_name,employee_position,employee_salary)


conn.close()
    
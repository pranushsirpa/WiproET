import pymysql

conn=pymysql.connect(host="localhost",user="root",password="rps@123",db="pythonsqlassgn")
cur=conn.cursor()
cur.execute("select id,name from USERS")
records=cur.fetchall()
for rec in records:
    print(rec[0],rec[1])

conn.close()

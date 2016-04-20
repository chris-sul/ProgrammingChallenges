def fac(num):
    if(num ==1):
        return num
    else:
        return(fac(num-1) * num)

a = input()
print(fac(int(a)))
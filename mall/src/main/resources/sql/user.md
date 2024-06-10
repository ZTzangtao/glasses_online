
selectUser
===
select id, user_name, user_password from glasses_user where 1 = 1
    -- @ if(isNotEmpty(name)){
        and user_name like #{'%' + name + '%'}
    -- @ }


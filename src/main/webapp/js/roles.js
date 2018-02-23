$(document).ready(function(){
	getRoles();
	
	function getRoles(){
		post(
			getHost() + "role/getRoles",
			{},
			function success(res){
				layer.msg("获取角色列表：" + res.msg);
				if(res.code == 0){
					
				}
			}, function error(err){
				layer.msg("获取角色列表失败：" + err);
			}
		)
	}
});
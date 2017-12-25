package com.changhong.appserver.mapper;

import com.changhong.appserver.entity.RefreshTokenEntity;

public interface RefreshTokenMapper {

	/**
	 * 保存
	 */
	 Integer saveTokens(RefreshTokenEntity rTokenEntity);
	 
	 /**
	  * 根基uId查找
	  */
	 RefreshTokenEntity selectByUid(Integer uId);
	 
	 /**
	  * 重置有效时间
	  */
	 void updataRefreshToken(RefreshTokenEntity rTokenEntity);
	 
}

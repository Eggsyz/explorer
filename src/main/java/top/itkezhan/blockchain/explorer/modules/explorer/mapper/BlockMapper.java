package top.itkezhan.blockchain.explorer.modules.explorer.mapper;

import org.apache.ibatis.annotations.Param;
import top.itkezhan.blockchain.explorer.modules.explorer.dto.PointCount;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author eggsy
 * @since 2020-12-24
 */
public interface BlockMapper extends BaseMapper<Block> {
    List<PointCount> listByMinute(@Param("networkName") String networkName,
                                  @Param("channelName") String channelName,
                                  @Param("startTime") Date startTime,
                                  @Param("endTime") Date endTime);

    List<PointCount> listByHour(@Param("networkName") String networkName,
                                @Param("channelName") String channelName,
                                @Param("startTime") Date startTime,
                                @Param("endTime") Date endTime);

    List<PointCount> listByDay(@Param("networkName") String networkName,
                               @Param("channelName") String channelName,
                               @Param("startTime") Date startTime,
                               @Param("endTime") Date endTime);
}

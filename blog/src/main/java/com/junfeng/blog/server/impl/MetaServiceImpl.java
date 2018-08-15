package com.junfeng.blog.server.impl;

import com.junfeng.blog.model.Meta;
import com.junfeng.blog.repository.MetaRepository;
import com.junfeng.blog.server.MetaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author junfeng
 * @Date 2018/8/3 21:27
 * Created by adminstor on 2018/8/3.
 */
@Service
public class MetaServiceImpl implements MetaService {
    @Resource
    private MetaRepository metaRepository;
    @Override
    public List<Meta> findAll() {
        return metaRepository.findAll();
    }

    @Override
    public Meta save(Meta meta) {
        return metaRepository.save(meta);
    }

    @Override
    public void saveAll(List<Meta> metas) {
        List<Meta> saveMetas;
        if(metas != null && metas.size() > 0){
            saveMetas = metas.stream().filter(meta -> !Objects.isNull(metaRepository.findMetaByName(meta.getName())))
                    .collect(Collectors.toList());
            metaRepository.saveAll(saveMetas);
        }
    }

}

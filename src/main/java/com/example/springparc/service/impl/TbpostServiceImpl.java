package com.example.springparc.service.impl;

import com.example.springparc.domain.Tbpost;
import com.example.springparc.dto.CommonDto;
import com.example.springparc.dto.TbpostDto;
import com.example.springparc.mapper.TbpostMapper;
import com.example.springparc.repository.TbpostRepository;
import com.example.springparc.service.TbpostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbpostServiceImpl implements TbpostService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TbpostRepository tbpostRepository;
    private final TbpostMapper tbpostMapper;

    public TbpostServiceImpl(
            TbpostRepository tbpostRepository
            , TbpostMapper tbpostMapper
    ) {
        this.tbpostRepository = tbpostRepository;
        this.tbpostMapper = tbpostMapper;
    }

    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param){
        return tbpostRepository.save(param.toEntity()).toAfterCreateDto();
    }

    public TbpostDto.CreateResDto update(TbpostDto.UpdateReqDto param){
        System.out.println(param);
        Tbpost tbpost = tbpostRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            tbpost.setDeleted(param.getDeleted());
        }
        if(param.getTitle() != null) {
            tbpost.setTitle(param.getTitle());
        }
        if(param.getCate() != null) {
            tbpost.setCate(param.getCate());
        }
        if(param.getContent() != null) {
            tbpost.setContent(param.getContent());
        }
        return tbpostRepository.save(tbpost).toAfterCreateDto();
    }

    public TbpostDto.SelectResDto get(String id){
        //System.out.println(id);
        TbpostDto.SelectResDto selectDto = tbpostMapper.detail(id);
        //
        return selectDto;
    }

    public List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param){
        List<TbpostDto.SelectResDto> list = tbpostMapper.list(param);
        /*
        List<TbpostDto.SelectResDto> newlist = new ArrayList<>();
        for(TbpostDto.SelectResDto tbpostSelectDto : list){
            newlist.add(get(tbpostSelectDto.getId()));
        }*/
        return addListDetails(list);
    }

    public List<TbpostDto.SelectResDto> moreList(TbpostDto.MoreListReqDto param){
        /*
        param.afterBuild();
        logger.info(param.getCursor());
        List<TbpostDto.SelectResDto> list = tbpostMapper.moreList(param);
        return addListDetails(list);
         */
        param.afterBuild();
        logger.info(param.getCursor());
        return addListDetails(tbpostMapper.moreList(param));
    }

    public CommonDto.PagedListResDto<TbpostDto.SelectResDto> pagedlist(TbpostDto.PagedListReqDto param){
        CommonDto.PagedListResDto<TbpostDto.SelectResDto> returnDto = new CommonDto.PagedListResDto<>();
        TbpostDto.PagedListServDto newParam = new TbpostDto.PagedListServDto();
        newParam.afterBuild(tbpostMapper.pagedListCount(param), param);
        return returnDto.afterBuild(addListDetails(tbpostMapper.pagedList(newParam)), newParam);

        /*
        CommonDto.PagedListResDto<TbpostDto.SelectResDto> returnDto = new CommonDto.PagedListResDto<>();
        int count = tbpostMapper.pagedListCount(param);

        TbpostDto.PagedListServDto newParam2 = new TbpostDto.PagedListServDto();
        newParam2.afterBuild(count, param);

        List<TbpostDto.SelectResDto> pagedlist = tbpostMapper.pagedList(newParam2);
        pagedlist = addListDetails(pagedlist);

        returnDto = returnDto.afterBuild(pagedlist, newParam2);
        */

        /* CommonDto.PagedListResDto<TbpostDto.SelectResDto> returnDto = new CommonDto.PagedListResDto<>();
        //총 갯수 알수 있습니다!
        int count = tbpostMapper.pagedListCount(param);
        System.out.println("count : " + count);

        int perpage = param.getPerpage();

        int lastpage = (int) count / perpage;
        if(count % perpage != 0){
            lastpage++;
        }
        //고객이 실제로 요청한 콜페이지
        int callpage = param.getCallpage();

        //고객이 요청한 페이지의 첫번째 자료의 순번
        int calllimit = (callpage - 1) * perpage;

        //param.setOrderby("created_at");
        //param.setOrderway("desc");
        param.setCallpage(callpage);
        param.calllimit(calllimit);

        List<TbpostDto.SelectResDto> pagedlist = tbpostMapper.pagedList(param);
        List<TbpostDto.SelectResDto> newlist = new ArrayList<>();
        for(TbpostDto.SelectResDto tbpostSelectDto : pagedlist){
            newlist.add(get(tbpostSelectDto.getId()));
        }

        returnDto.setCallpage(callpage);
        returnDto.setLastpage(lastpage);
        returnDto.setPerpage(perpage);
        returnDto.setListsize(count);

        returnDto.setList(newlist);

        return returnDto;
        */

    }

    public List<TbpostDto.SelectResDto> addListDetails(List<TbpostDto.SelectResDto> a_list){
        List<TbpostDto.SelectResDto> result_list = new ArrayList<>();
        for(TbpostDto.SelectResDto a : a_list){
            result_list.add(get(a.getId()));
        }
        return result_list;
    }

}

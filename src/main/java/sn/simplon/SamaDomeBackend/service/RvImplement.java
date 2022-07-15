package sn.simplon.SamaDomeBackend.service;

import org.springframework.stereotype.Service;
import sn.simplon.SamaDomeBackend.Exception.RvNotFoundException;
import sn.simplon.SamaDomeBackend.dtos.RvDTO;
import sn.simplon.SamaDomeBackend.entity.Rv;
import sn.simplon.SamaDomeBackend.mappers.Mapper;
import sn.simplon.SamaDomeBackend.repository.RvRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RvImplement implements RvService{

    private RvRepository rvRepository;
    private Mapper mapperDTO;
    
    @Override
    public RvDTO saveRv(RvDTO rvDTO) throws RvNotFoundException {
        Rv rv =mapperDTO.fromRvDTO(rvDTO);
        Rv rvSave=rvRepository.save(rv);
        return mapperDTO.fromRv(rvSave);
    }

    @Override
    public List<RvDTO> getAllRv() {
        List<Rv> rvList= rvRepository.findAll();
        List<RvDTO> rvDTOS=rvList.stream()
         .map(rv-> mapperDTO.fromRv(rv))
         .collect(Collectors.toList());
        return rvDTOS;
    }

    @Override
    public RvDTO getOneRv(Long id) throws RvNotFoundException {
        Rv rv= rvRepository.findById(id)
        .orElseThrow(()->new RvNotFoundException("Cet rv n'existe pas"));
        return mapperDTO.fromRv(rv);
    }

    @Override
    public RvDTO updateRv(RvDTO rvDTO) {
        Rv rv=mapperDTO.fromRvDTO(rvDTO);
        Rv rvUpdate=rvRepository.save(rv);
        return mapperDTO.fromRv(rvUpdate);
    }

    @Override
    public void deleteRv(Long id) throws RvNotFoundException {
        Rv rv= rvRepository.findById(id)
                .orElseThrow(()->new RvNotFoundException("Cet id n'existe pas"));
        rvRepository.delete(rv);
    }
}

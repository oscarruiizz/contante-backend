package net.ausiasmarch.contante.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.contante.entity.GrupotipocuentaEntity;
import net.ausiasmarch.contante.service.GrupotipocuentaService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/grupoTipoCuenta")
public class Grupotipocuenta {

     @Autowired
        GrupotipocuentaService oGrupoTipoCuentaService;
    
        @GetMapping("")
        public ResponseEntity<Page<GrupotipocuentaEntity>> getPage(
                Pageable oPageable,
                @RequestParam  Optional<String> filter) {
            return new ResponseEntity<Page<GrupotipocuentaEntity>>(oGrupoTipoCuentaService.getPage(oPageable, filter), HttpStatus.OK);
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<GrupotipocuentaEntity> getGrupoTipoCuenta(@PathVariable Long id) {
            return new ResponseEntity<GrupotipocuentaEntity>(oGrupoTipoCuentaService.get(id), HttpStatus.OK);
        }
    
        @GetMapping("/count")
        public ResponseEntity<Long> count() {
            return new ResponseEntity<Long>(oGrupoTipoCuentaService.count(), HttpStatus.OK);
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Long> delete(@PathVariable Long id) {
            return new ResponseEntity<Long>(oGrupoTipoCuentaService.delete(id), HttpStatus.OK);
        }
    
        @PutMapping("")
        public ResponseEntity<GrupotipocuentaEntity> create(@RequestBody GrupotipocuentaEntity oGrupoTipoCuentaEntity) {
            return new ResponseEntity<GrupotipocuentaEntity>(oGrupoTipoCuentaService.create(oGrupoTipoCuentaEntity), HttpStatus.OK);
        }
    
        @PostMapping("")
        public ResponseEntity<GrupotipocuentaEntity> update(@RequestBody GrupotipocuentaEntity oGrupoTipoCuentaEntity) {
            return new ResponseEntity<GrupotipocuentaEntity>(oGrupoTipoCuentaService.update(oGrupoTipoCuentaEntity), HttpStatus.OK);
        }
    
    /* 
        @PutMapping("/random/{cantidad}")
        public ResponseEntity<Long> create(@PathVariable Long cantidad) {
            return new ResponseEntity<Long>(oGrupoTipoCuentaService.randomCreate(cantidad), HttpStatus.OK);
        }

        */
        
        @DeleteMapping("/all")
        public ResponseEntity<Long> deleteAll() {
            return new ResponseEntity<Long>(oGrupoTipoCuentaService.deleteAll(), HttpStatus.OK);
        }

        @DeleteMapping("/delete/{idb}/{idtc}")
        public ResponseEntity<Long> deleteByIds(@PathVariable Long idb, @PathVariable Long idtc) {
            return new ResponseEntity<Long>(oGrupoTipoCuentaService.deleteByIds(idb, idtc), HttpStatus.OK);
        }
    
    }
    

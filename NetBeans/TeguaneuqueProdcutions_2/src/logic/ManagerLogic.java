/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ManagerLogic {
    private GroupResource groupResource = null;
    private ResourceQuantity resourceQuantity = null;

    public ManagerLogic() {
        groupResource = GroupResource.instanceOfGroup();
        resourceQuantity = new ResourceQuantity();
    }
    
    public void addResource(Resource resource){
        groupResource.add(resource);
    }
    
    public void printResource(){
        System.out.println("----------------------------------");
        System.out.println("tamaño lista group resource"+groupResource.size());
        for (int i = 0; i < groupResource.size(); i++) {
            System.out.println(""+groupResource.get(i));
        }
    }

    public GroupResource getGroupResource() {
        return groupResource;
    }
    
    
    
    public boolean agregarResourceQuantity(double cantidad, int idGroupResource){
        
        if (resourceQuantity.setResourceQuantity(1.5, 5)) {
             return true;
         }else{
             return false;
         }
    }
    
    public static void main(String[] args) {
      
        GroupResource groupResource = GroupResource.instanceOfGroup();
        
         groupResource.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
         groupResource.add(new Resource("Tiempo horneo", UnitOfMeasure.MINUTES, TypeResource.TIME));
         groupResource.add(new Resource("aZUCAR", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
         groupResource.add(new Resource("Molde", UnitOfMeasure.UNIT, TypeResource.ELEMENT));
         
         ResourceQuantity resourceQuantity = new ResourceQuantity();
         if (resourceQuantity.setResourceQuantity(1.5, 5)) {
             System.out.println("AgrEgado");
         }
         else{
             System.out.println("No existe");
         };

        ResourceQuantity resourceQuantity1 = new ResourceQuantity(1.5, 2);
                
    }
}

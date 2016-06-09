import java.util.*;
import java.util.stream.Collectors;

public class _12_LegendaryFarming {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int requred = 250;
        int item = 0;
        TreeMap<String, Integer> junk = new TreeMap<>();
        TreeMap<String, Integer> remainingKeyMaterials = new TreeMap<>();
        int shadowmourneSum = 0;
        int valanyrSum = 0;
        int dragonwrathSum = 0;
        boolean isObtainedShadowmourne = false;
        boolean isObtainedValanyr = false;
        boolean isObtainedDragonwrath = false;

        while (true){

            int quantity = input.nextInt();
            String material = input.next().toLowerCase();
            boolean addMaterial = false;

            switch (material){
                case "shards":

                    shadowmourneSum += quantity;
                    quantity = 0;
                    if (shadowmourneSum == requred){
                        isObtainedShadowmourne = true;
                        quantity = 0;
                        item = 1;
                    } else if (shadowmourneSum > requred){
                        quantity = shadowmourneSum - requred;
                        isObtainedShadowmourne = true;
                        item = 1;
                    }
                    addMaterial = true;
                    break;
                case "fragments":

                    valanyrSum += quantity;
                    quantity = 0;
                    if (valanyrSum == requred){
                        isObtainedValanyr = true;
                        item = 2;
                    } else if (valanyrSum > requred){
                        quantity = valanyrSum - requred;
                        isObtainedValanyr = true;
                        item = 2;
                    }
                    addMaterial = true;
                    break;
                case "motes":

                    dragonwrathSum += quantity;
                    quantity = 0;
                    if (dragonwrathSum == requred){
                        isObtainedDragonwrath = true;
                        item = 3;
                    } else if (dragonwrathSum > requred){
                        quantity = dragonwrathSum - requred;
                        isObtainedDragonwrath = true;
                        item = 3;
                    }
                    addMaterial = true;
                    break;
                default:
                    break;
            }

            if (isObtainedShadowmourne || isObtainedValanyr || isObtainedDragonwrath){

                remainingKeyMaterials.put(material, quantity);
                switch (item){
                    case 1:
                        System.out.println("Shadowmourne obtained!");
                        remainingKeyMaterials.put("fragments", valanyrSum);
                        remainingKeyMaterials.put("motes", dragonwrathSum);
                        break;
                    case 2:
                        System.out.println("Valanyr obtained!");
                        remainingKeyMaterials.put("shards", shadowmourneSum);
                        remainingKeyMaterials.put("motes", dragonwrathSum);
                        break;
                    case 3:
                        System.out.println("Dragonwrath obtained!");
                        remainingKeyMaterials.put("fragments", valanyrSum);
                        remainingKeyMaterials.put("shards", shadowmourneSum);
                        break;
                }

                if (!material.equals("shards") && !material.equals("fragments") && !material.equals("motes")) {
                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        int newQuantity = junk.get(material) + quantity;
                        junk.put(material, newQuantity);
                    }
                }

                break;
            }

            if (!addMaterial) {
                if (!junk.containsKey(material)) {
                    junk.put(material, quantity);
                } else {
                    int newQuantity = junk.get(material) + quantity;
                    junk.put(material, newQuantity);
                }
            }
        }

        LinkedHashMap<String, Integer> sortedRemainingKeyMaterials = remainingKeyMaterials
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) : Integer.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap<String, Integer>::new));

        for (String s : sortedRemainingKeyMaterials.keySet()) {
            System.out.println(s + ": " + sortedRemainingKeyMaterials.get(s));
        }

        LinkedHashMap<String, Integer> sortedJunkMaterials = junk
                .entrySet()
                .stream()
                .sorted((k1, k2) -> k1.getKey().compareTo(k2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));

        for (String s : sortedJunkMaterials.keySet()) {
            System.out.println(s + ": " + sortedJunkMaterials.get(s));
        }
    }
}

import java.util.Comparator;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class17 implements Comparator {
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   static RSSocket field324;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -520684283
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("m")
   static int[] field322;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(La;La;I)I",
      garbageValue = "-1720735488"
   )
   int method118(class14 var1, class14 var2) {
      return var1.field294.price < var2.field294.price?-1:(var2.field294.price == var1.field294.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method118((class14)var1, (class14)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lia;",
      garbageValue = "1723882920"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3559.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1634563063"
   )
   static String method126() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class96.field1516.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}

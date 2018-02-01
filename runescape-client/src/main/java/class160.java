import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class160 {
   @ObfuscatedName("p")
   static boolean field2130;
   @ObfuscatedName("w")
   static Hashtable field2131;
   @ObfuscatedName("m")
   @Export("spritePixels")
   static byte[][] spritePixels;
   @ObfuscatedName("fk")
   static byte[][] field2132;

   static {
      field2130 = false;
      field2131 = new Hashtable(16);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;I)V",
      garbageValue = "807624593"
   )
   public static void method3146(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3412 = var1;
      KitDefinition.field3406 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;B)Z",
      garbageValue = "30"
   )
   public static boolean method3142(IndexDataBase var0, IndexDataBase var1) {
      Area.field3369 = var1;
      if(!var0.method4371()) {
         return false;
      } else {
         Area.field3354 = var0.fileCount(35);
         Area.mapAreaType = new Area[Area.field3354];

         for(int var2 = 0; var2 < Area.field3354; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.mapAreaType[var2] = new Area(var2);
               Area.mapAreaType[var2].method4553(new Buffer(var3));
               Area.mapAreaType[var2].method4570();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lik;III)Z",
      garbageValue = "512846023"
   )
   static boolean method3147(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Coordinates.decodeSprite(var3);
         return true;
      }
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class279 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static IndexDataBase field3552;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   public static NodeCache field3553;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   IterableHashTable field3554;

   static {
      field3553 = new NodeCache(64);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public void method4925() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-1364819274"
   )
   public void method4937(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4923(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "-1298637294"
   )
   void method4923(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3554 = class28.readStringIntParameters(var1, this.field3554);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   public int method4924(int var1, int var2) {
      IterableHashTable var4 = this.field3554;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1573910847"
   )
   public String method4932(int var1, String var2) {
      return WorldMapType1.method309(this.field3554, var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Liu;B)Z",
      garbageValue = "127"
   )
   public static boolean method4922(class245 var0) {
      return class245.field2976 == var0 || class245.field2969 == var0 || class245.field2965 == var0 || class245.field2970 == var0 || class245.field2967 == var0 || class245.field2968 == var0 || class245.field2971 == var0 || class245.field2966 == var0;
   }
}

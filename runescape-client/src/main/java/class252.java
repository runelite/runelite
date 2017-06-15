import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class252 extends CacheableNode {
   @ObfuscatedName("m")
   public static NodeCache field3400;
   @ObfuscatedName("e")
   class186 field3401;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "95"
   )
   public void method4314() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "1"
   )
   public void method4315(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4316(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1621715542"
   )
   void method4316(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3401 = class172.method3016(var1, this.field3401);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-33"
   )
   public int method4317(int var1, int var2) {
      return Script.method1758(this.field3401, var1, var2);
   }

   static {
      field3400 = new NodeCache(64);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "-2052564846"
   )
   public static Overlay method4319(int var0) {
      Overlay var1 = (Overlay)Overlay.field3597.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3594.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method4555(new Buffer(var2), var0);
         }

         var1.method4554();
         Overlay.field3597.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1184039181"
   )
   public String method4322(int var1, String var2) {
      return class165.method2965(this.field3401, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "506278977"
   )
   public static void method4337(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.field3584 = var0;
      NPCComposition.field3555 = var1;
   }
}

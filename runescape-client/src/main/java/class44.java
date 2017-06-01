import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class44 extends WorldMapData {
   @ObfuscatedName("j")
   List field579;
   @ObfuscatedName("z")
   HashSet field581;
   @ObfuscatedName("au")
   protected static boolean field582;
   @ObfuscatedName("q")
   HashSet field583;
   @ObfuscatedName("r")
   static class47 field585;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LOverlay;",
      garbageValue = "0"
   )
   public static Overlay method604(int var0) {
      Overlay var1 = (Overlay)Overlay.field3583.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3587.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method4676(new Buffer(var2), var0);
         }

         var1.method4672();
         Overlay.field3583.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;LBuffer;IZB)V",
      garbageValue = "0"
   )
   void method605(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field581 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method142(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field581.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field583 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method612(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field583.add(var9);
      }

      this.method606(var2, var5);
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(LBuffer;ZB)V",
      garbageValue = "1"
   )
   void method606(Buffer var1, boolean var2) {
      this.field579 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3156();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field579.add(new class25(var5, var6));
         }
      }

   }
}

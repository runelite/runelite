import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class44 extends WorldMapData {
   @ObfuscatedName("q")
   HashSet field537;
   @ObfuscatedName("v")
   HashSet field538;
   @ObfuscatedName("n")
   List field539;

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Lgj;Lgj;Lgj;IZB)V",
      garbageValue = "55"
   )
   void method621(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field537 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method172(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field537.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field538 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method630(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field538.add(var9);
      }

      this.method625(var2, var5);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(Lgj;ZI)V",
      garbageValue = "1401196121"
   )
   void method625(Buffer var1, boolean var2) {
      this.field539 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3414();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field539.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)Lil;",
      garbageValue = "10098"
   )
   public static class254 method622(int var0) {
      class254 var1 = (class254)class254.field3375.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3376.getConfigData(19, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4579(new Buffer(var2));
         }

         class254.field3375.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   static final int method628(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1064702256"
   )
   static final void method626(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var9 * var11 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      Actor.cameraX = var0 - var8;
      class60.cameraZ = var1 - var9;
      GameCanvas.cameraY = var2 - var10;
      SceneTilePaint.cameraPitch = var3;
      class33.cameraYaw = var4;
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(Lho;II)Ljava/lang/String;",
      garbageValue = "15671030"
   )
   static String method627(Widget var0, int var1) {
      return !class21.method168(class60.getWidgetConfig(var0), var1) && var0.field2838 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}

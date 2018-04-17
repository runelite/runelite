import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static Track1 field1300;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -643471269
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1956042379
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 20097807
   )
   @Export("level")
   int level;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1252882277
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -33019839
   )
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 324319727
   )
   @Export("height")
   int height;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   Sequence field1298;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1552850479
   )
   int field1292;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 377667007
   )
   int field1304;
   @ObfuscatedName("x")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1292 = 0;
      this.field1304 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class86.getSpotAnimType(this.id).field3497;
      if(var8 != -1) {
         this.finished = false;
         this.field1298 = CombatInfo1.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   final void method1851(int var1) {
      if(!this.finished) {
         this.field1304 += var1;

         while(this.field1304 > this.field1298.frameLengths[this.field1292]) {
            this.field1304 -= this.field1298.frameLengths[this.field1292];
            ++this.field1292;
            if(this.field1292 >= this.field1298.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lei;",
      garbageValue = "1329079562"
   )
   protected final Model getModel() {
      Spotanim var1 = class86.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1292);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "120"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class264.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class264.NetCache_socket.vmethod3337(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class264.NetCache_socket.vmethod3331();
            } catch (Exception var3) {
               ;
            }

            ++class264.field3431;
            class264.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "283412280"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}

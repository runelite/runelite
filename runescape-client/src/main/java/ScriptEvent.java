import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -817434855
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 475850421
   )
   static int field772;
   @ObfuscatedName("s")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("g")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2084659539
   )
   int field774;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -518996007
   )
   int field775;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1985978545
   )
   int field781;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   Widget field777;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1013702635
   )
   int field784;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 523443273
   )
   int field779;
   @ObfuscatedName("k")
   @Export("string")
   String string;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 409340381
   )
   int field771;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   class230 field782;

   public ScriptEvent() {
      this.field782 = class230.field2901;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "1383527630"
   )
   public void method1065(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhj;I)V",
      garbageValue = "1647906984"
   )
   public void method1066(class230 var1) {
      this.field782 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lir;IIB)Lki;",
      garbageValue = "-96"
   )
   public static SpritePixels method1074(IndexDataBase var0, int var1, int var2) {
      if(!class35.method484(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class310.field3908;
         var4.maxHeight = class310.field3910;
         var4.offsetX = class219.field2698[0];
         var4.offsetY = class263.offsetsY[0];
         var4.width = class60.field708[0];
         var4.height = class310.field3911[0];
         int var5 = var4.width * var4.height;
         byte[] var6 = class310.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class289.field3786[var6[var7] & 255];
         }

         Name.method5282();
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "788985924"
   )
   static int method1073(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class216.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class94.field1418:ItemLayer.field1668;
      }

      if(var0 == 1927) {
         if(class80.field1250 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2812 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.objs = var3.field2812;
            var4.field771 = class80.field1250 + 1;
            Client.field1023.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(ZLgt;I)V",
      garbageValue = "1644506536"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field937.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5 = var1.getBits(1);
               if(var5 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               int var6 = var1.getBits(1);
               int var7;
               if(var0) {
                  var7 = var1.getBits(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = var1.getBits(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               var4.composition = Spotanim.getNpcDefinition(var1.getBits(14));
               int var8;
               if(var0) {
                  var8 = var1.getBits(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = var1.getBits(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               int var9 = Client.field952[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var9;
               }

               var4.field1127 = var4.composition.field3633;
               var4.field1167 = var4.composition.field3634;
               if(var4.field1167 == 0) {
                  var4.angle = 0;
               }

               var4.field1156 = var4.composition.field3627;
               var4.field1123 = var4.composition.field3640;
               var4.field1124 = var4.composition.field3645;
               var4.field1125 = var4.composition.field3642;
               var4.idlePoseAnimation = var4.composition.field3636;
               var4.field1120 = var4.composition.field3637;
               var4.field1121 = var4.composition.field3639;
               var4.method1852(GroundObject.localPlayer.pathX[0] + var8, GroundObject.localPlayer.pathY[0] + var7, var6 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}

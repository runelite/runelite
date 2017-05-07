import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class49 extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1468539517
   )
   int field946;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -276626943
   )
   int field947;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1989936399
   )
   int field948;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 842536465
   )
   int field949;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 25434917
   )
   int field950;
   @ObfuscatedName("u")
   Sequence field951;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1840535081
   )
   int field953;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -836469041
   )
   int field955;
   @ObfuscatedName("ej")
   static SpritePixels[] field956;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1513313869
   )
   int field958;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "0"
   )
   static int method913(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method606()?(var1.method606()?0:1):(var1.method606()?-1:0)):(var2 == 5?(var0.method604()?(var1.method604()?0:1):(var1.method604()?-1:0)):(var2 == 6?(var0.method605()?(var1.method605()?0:1):(var1.method605()?-1:0)):(var2 == 7?(var0.method603()?(var1.method603()?0:1):(var1.method603()?-1:0)):var0.id - var1.id)))));
      }
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field948 = var1;
      this.field946 = var2;
      this.field947 = var3;
      this.field955 = var4;
      this.field949 = var5;
      this.field950 = var6;
      if(var7 != -1) {
         this.field951 = NPCComposition.getAnimation(var7);
         this.field958 = 0;
         this.field953 = Client.gameCycle - 1;
         if(this.field951.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field951 == var10.field951) {
               this.field958 = var10.field958;
               this.field953 = var10.field953;
               return;
            }
         }

         if(var8 && this.field951.frameStep != -1) {
            this.field958 = (int)(Math.random() * (double)this.field951.frameIDs.length);
            this.field953 -= (int)(Math.random() * (double)this.field951.frameLenghts[this.field958]);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   public static void method915(int var0) {
      class115.mouseIdleTicks = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LScript;",
      garbageValue = "-897015559"
   )
   static Script method918(int var0) {
      Script var1 = (Script)Script.field944.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class107.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new Script();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 2;
            int var4 = var3.readUnsignedShort();
            int var5 = var3.payload.length - 2 - var4 - 12;
            var3.offset = var5;
            int var6 = var3.readInt();
            var1.localIntCount = var3.readUnsignedShort();
            var1.localStringCount = var3.readUnsignedShort();
            var1.intStackCount = var3.readUnsignedShort();
            var1.stringStackCount = var3.readUnsignedShort();
            int var7 = var3.readUnsignedByte();
            int var8;
            int var9;
            if(var7 > 0) {
               var1.switches = var1.method905(var7);

               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var3.readUnsignedShort();
                  class142 var10 = new class142(CombatInfo1.method596(var9));
                  var1.switches[var8] = var10;

                  while(var9-- > 0) {
                     int var11 = var3.readInt();
                     int var12 = var3.readInt();
                     var10.method2729(new class154(var12), (long)var11);
                  }
               }
            }

            var3.offset = 0;
            var3.method2389();
            var1.instructions = new int[var6];
            var1.intOperands = new int[var6];
            var1.stringOperands = new String[var6];

            for(var8 = 0; var3.offset < var5; var1.instructions[var8++] = var9) {
               var9 = var3.readUnsignedShort();
               if(var9 == 3) {
                  var1.stringOperands[var8] = var3.readString();
               } else if(var9 < 100 && var9 != 21 && var9 != 38 && var9 != 39) {
                  var1.intOperands[var8] = var3.readInt();
               } else {
                  var1.intOperands[var8] = var3.readUnsignedByte();
               }
            }

            Script.field944.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-642248326"
   )
   static final void method919(Widget var0, int var1, int var2) {
      if(Client.field458 == null && !Client.isMenuOpen) {
         if(var0 != null && class65.method1189(var0) != null) {
            Client.field458 = var0;
            Client.field496 = class65.method1189(var0);
            Client.field492 = var1;
            Client.field461 = var2;
            class99.field1638 = 0;
            Client.field469 = false;
            int var3 = class114.method2212();
            if(var3 != -1) {
               class109.method2065(var3);
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-18"
   )
   protected final Model getModel() {
      if(this.field951 != null) {
         int var12 = Client.gameCycle - this.field953;
         if(var12 > 100 && this.field951.frameStep > 0) {
            var12 = 100;
         }

         label67: {
            do {
               do {
                  if(var12 <= this.field951.frameLenghts[this.field958]) {
                     break label67;
                  }

                  var12 -= this.field951.frameLenghts[this.field958];
                  ++this.field958;
               } while(this.field958 < this.field951.frameIDs.length);

               this.field958 -= this.field951.frameStep;
            } while(this.field958 >= 0 && this.field958 < this.field951.frameIDs.length);

            this.field951 = null;
         }

         this.field953 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class26.getObjectDefinition(this.field948);
      if(var1.impostorIds != null) {
         var1 = var1.getImpostor();
      }

      if(var1 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field947 != 1 && this.field947 != 3) {
            var2 = var1.sizeX;
            var3 = var1.sizeY;
         } else {
            var2 = var1.sizeY;
            var3 = var1.sizeX;
         }

         int var4 = this.field949 + (var2 >> 1);
         int var5 = (var2 + 1 >> 1) + this.field949;
         int var6 = this.field950 + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.field950;
         int[][] var8 = class10.tileHeights[this.field955];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.field949 << 7) + (var2 << 6);
         int var11 = (this.field950 << 7) + (var3 << 6);
         return var1.method3686(this.field946, this.field947, var8, var10, var9, var11, this.field951, this.field958);
      }
   }
}

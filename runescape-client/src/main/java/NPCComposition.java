import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("x")
   short[] field904;
   @ObfuscatedName("h")
   public static class170 field905;
   @ObfuscatedName("e")
   static NodeCache field906 = new NodeCache(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1580258479
   )
   public int field907 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 286422271
   )
   @Export("id")
   public int id;
   @ObfuscatedName("u")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1731524807
   )
   public int field910 = 1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1063797459
   )
   int field911 = 0;
   @ObfuscatedName("m")
   int[] field912;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1876092919
   )
   int field913 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1615032879
   )
   public int field915 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 84996981
   )
   public int field916 = -1;
   @ObfuscatedName("g")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1522305863
   )
   public int field918 = -1;
   @ObfuscatedName("i")
   public static class170 field919;
   @ObfuscatedName("w")
   short[] field920;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2062871965
   )
   public int field921 = -1;
   @ObfuscatedName("k")
   short[] field922;
   @ObfuscatedName("z")
   short[] field923;
   @ObfuscatedName("q")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("o")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1279279983
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("au")
   public boolean field927 = false;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1555521637
   )
   int field928 = 128;
   @ObfuscatedName("a")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 138344469
   )
   public int field930 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1218610567
   )
   int field931 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1753741507
   )
   int field932 = 128;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1209802925
   )
   public int field933 = 32;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1717513455
   )
   public int field934 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1775827159
   )
   public int field935 = -1;
   @ObfuscatedName("l")
   @Export("models")
   int[] models;
   @ObfuscatedName("ag")
   public boolean field937 = true;
   @ObfuscatedName("ak")
   public int[] field938;
   @ObfuscatedName("al")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1911359943
   )
   int field940 = -1;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method804() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "6"
   )
   void method805(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method806(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-61687485"
   )
   void method806(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2544();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method2546();
         }
      } else if(var2 == 2) {
         this.name = var1.method2552();
      } else if(var2 == 12) {
         this.field910 = var1.method2544();
      } else if(var2 == 13) {
         this.field934 = var1.method2546();
      } else if(var2 == 14) {
         this.field916 = var1.method2546();
      } else if(var2 == 15) {
         this.field921 = var1.method2546();
      } else if(var2 == 16) {
         this.field915 = var1.method2546();
      } else if(var2 == 17) {
         this.field916 = var1.method2546();
         this.field930 = var1.method2546();
         this.field918 = var1.method2546();
         this.field907 = var1.method2546();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2552();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2544();
         this.field920 = new short[var3];
         this.field904 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field920[var4] = (short)var1.method2546();
            this.field904[var4] = (short)var1.method2546();
         }
      } else if(var2 == 41) {
         var3 = var1.method2544();
         this.field922 = new short[var3];
         this.field923 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field922[var4] = (short)var1.method2546();
            this.field923[var4] = (short)var1.method2546();
         }
      } else if(var2 == 60) {
         var3 = var1.method2544();
         this.field912 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field912[var4] = var1.method2546();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method2546();
      } else if(var2 == 97) {
         this.field932 = var1.method2546();
      } else if(var2 == 98) {
         this.field928 = var1.method2546();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field911 = var1.method2545();
      } else if(var2 == 101) {
         this.field931 = var1.method2545() * 5;
      } else if(var2 == 102) {
         this.field935 = var1.method2546();
      } else if(var2 == 103) {
         this.field933 = var1.method2546();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field937 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field927 = true;
         }
      } else {
         this.field940 = var1.method2546();
         if(this.field940 == '\uffff') {
            this.field940 = -1;
         }

         this.field913 = var1.method2546();
         if(this.field913 == '\uffff') {
            this.field913 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.method2546();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2544();
         this.field938 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field938[var5] = var1.method2546();
            if(this.field938[var5] == '\uffff') {
               this.field938[var5] = -1;
            }
         }

         this.field938[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "47"
   )
   public final ModelData method808() {
      if(this.field938 != null) {
         NPCComposition var6 = this.method813();
         return null == var6?null:var6.method808();
      } else if(this.field912 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var5 = 0; var5 < this.field912.length; ++var5) {
            if(!field905.method3291(this.field912[var5], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field912.length];

            for(int var7 = 0; var7 < this.field912.length; ++var7) {
               var2[var7] = ModelData.method2245(field905, this.field912[var7], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(this.field920 != null) {
               for(var4 = 0; var4 < this.field920.length; ++var4) {
                  var3.method2315(this.field920[var4], this.field904[var4]);
               }
            }

            if(null != this.field922) {
               for(var4 = 0; var4 < this.field922.length; ++var4) {
                  var3.method2258(this.field922[var4], this.field923[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "317956368"
   )
   public final NPCComposition method813() {
      int var1 = -1;
      if(this.field940 != -1) {
         var1 = class9.method127(this.field940);
      } else if(this.field913 != -1) {
         var1 = class179.widgetSettings[this.field913];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field938.length - 1) {
         var2 = this.field938[var1];
      } else {
         var2 = this.field938[this.field938.length - 1];
      }

      return var2 != -1?Friend.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "0"
   )
   public final Model method814(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field938 != null) {
         NPCComposition var12 = this.method813();
         return var12 == null?null:var12.method814(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var11 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field905.method3291(this.models[var7], 0)) {
                  var11 = true;
               }
            }

            if(var11) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2245(field905, this.models[var9], 0);
            }

            ModelData var10;
            if(var8.length == 1) {
               var10 = var8[0];
            } else {
               var10 = new ModelData(var8, var8.length);
            }

            if(this.field920 != null) {
               for(var9 = 0; var9 < this.field920.length; ++var9) {
                  var10.method2315(this.field920[var9], this.field904[var9]);
               }
            }

            if(this.field922 != null) {
               for(var9 = 0; var9 < this.field922.length; ++var9) {
                  var10.method2258(this.field922[var9], this.field923[var9]);
               }
            }

            var5 = var10.method2265(64 + this.field911, 850 + this.field931, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(var1 != null && var3 != null) {
            var6 = var1.method921(var5, var2, var3, var4);
         } else if(var1 != null) {
            var6 = var1.method900(var5, var2);
         } else if(var3 != null) {
            var6 = var3.method900(var5, var4);
         } else {
            var6 = var5.method2358(true);
         }

         if(this.field932 != 128 || this.field928 != 128) {
            var6.method2346(this.field932, this.field928, this.field932);
         }

         return var6;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-92"
   )
   public boolean method832() {
      if(this.field938 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field940 != -1) {
            var1 = class9.method127(this.field940);
         } else if(this.field913 != -1) {
            var1 = class179.widgetSettings[this.field913];
         }

         return var1 >= 0 && var1 < this.field938.length?this.field938[var1] != -1:this.field938[this.field938.length - 1] != -1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-12"
   )
   static void method837(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field681[var5] != var0) {
            var2[var4] = World.field681[var5];
            var3[var4] = World.field671[var5];
            ++var4;
         }
      }

      World.field681 = var2;
      World.field671 = var3;
      class23.method562(VertexNormal.worldList, 0, VertexNormal.worldList.length - 1, World.field681, World.field671);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;S)V",
      garbageValue = "-7460"
   )
   public static void method838(class170 var0) {
      class54.field1159 = var0;
   }
}

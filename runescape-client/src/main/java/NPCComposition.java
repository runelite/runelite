import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1502367333
   )
   @Export("id")
   public int id;
   @ObfuscatedName("e")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("r")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 249060179
   )
   public int field913 = -1;
   @ObfuscatedName("t")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1162754629
   )
   public int field915 = 1;
   @ObfuscatedName("i")
   @Export("models")
   int[] models;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -44740969
   )
   int field917 = 128;
   @ObfuscatedName("f")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("g")
   int[] field919;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -345734461
   )
   public int field920 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1741554701
   )
   public int field921 = -1;
   @ObfuscatedName("a")
   public static class170 field922;
   @ObfuscatedName("ap")
   public int[] field923;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 217993785
   )
   public int field924 = -1;
   @ObfuscatedName("b")
   short[] field925;
   @ObfuscatedName("p")
   short[] field926;
   @ObfuscatedName("o")
   short[] field927;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1841786299
   )
   public int field928 = -1;
   @ObfuscatedName("s")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 58755721
   )
   int field930 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1450979553
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("v")
   static NodeCache field932 = new NodeCache(64);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1096086571
   )
   int field933 = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -871838825
   )
   public int field934 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -278013397
   )
   public int field935 = -1;
   @ObfuscatedName("y")
   short[] field936;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -726029109
   )
   public int field937 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1193615149
   )
   public int field938 = 32;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 644843049
   )
   int field939 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -822426495
   )
   int field940 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 236069431
   )
   int field941 = -1;
   @ObfuscatedName("av")
   public boolean field942 = true;
   @ObfuscatedName("ao")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("aq")
   public boolean field944 = false;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-54"
   )
   void method806(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method807(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1108351978"
   )
   void method807(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2528();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method2717();
         }
      } else if(var2 == 2) {
         this.name = var1.method2530();
      } else if(var2 == 12) {
         this.field915 = var1.method2528();
      } else if(var2 == 13) {
         this.field935 = var1.method2717();
      } else if(var2 == 14) {
         this.field921 = var1.method2717();
      } else if(var2 == 15) {
         this.field934 = var1.method2717();
      } else if(var2 == 16) {
         this.field920 = var1.method2717();
      } else if(var2 == 17) {
         this.field921 = var1.method2717();
         this.field913 = var1.method2717();
         this.field928 = var1.method2717();
         this.field924 = var1.method2717();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2530();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2528();
         this.field925 = new short[var3];
         this.field926 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field925[var4] = (short)var1.method2717();
            this.field926[var4] = (short)var1.method2717();
         }
      } else if(var2 == 41) {
         var3 = var1.method2528();
         this.field927 = new short[var3];
         this.field936 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field927[var4] = (short)var1.method2717();
            this.field936[var4] = (short)var1.method2717();
         }
      } else if(var2 == 60) {
         var3 = var1.method2528();
         this.field919 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field919[var4] = var1.method2717();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method2717();
      } else if(var2 == 97) {
         this.field933 = var1.method2717();
      } else if(var2 == 98) {
         this.field917 = var1.method2717();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field930 = var1.method2529();
      } else if(var2 == 101) {
         this.field939 = var1.method2529() * 5;
      } else if(var2 == 102) {
         this.field937 = var1.method2717();
      } else if(var2 == 103) {
         this.field938 = var1.method2717();
      } else if(var2 == 106) {
         this.field940 = var1.method2717();
         if(this.field940 == '\uffff') {
            this.field940 = -1;
         }

         this.field941 = var1.method2717();
         if(this.field941 == '\uffff') {
            this.field941 = -1;
         }

         var3 = var1.method2528();
         this.field923 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field923[var4] = var1.method2717();
            if(this.field923[var4] == '\uffff') {
               this.field923[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field942 = false;
      } else if(var2 == 109) {
         this.isClickable = false;
      } else if(var2 == 111) {
         this.field944 = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "466981529"
   )
   public static SpritePixels method808(class170 var0, String var1, String var2) {
      int var3 = var0.method3324(var1);
      int var4 = var0.method3313(var3, var2);
      return class20.method565(var0, var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-238640898"
   )
   public final ModelData method809() {
      if(null != this.field923) {
         NPCComposition var1 = this.method810();
         return var1 == null?null:var1.method809();
      } else if(null == this.field919) {
         return null;
      } else {
         boolean var5 = false;

         for(int var6 = 0; var6 < this.field919.length; ++var6) {
            if(!class145.field2245.method3351(this.field919[var6], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field919.length];

            for(int var7 = 0; var7 < this.field919.length; ++var7) {
               var2[var7] = ModelData.method2284(class145.field2245, this.field919[var7], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(this.field925 != null) {
               for(var4 = 0; var4 < this.field925.length; ++var4) {
                  var3.method2239(this.field925[var4], this.field926[var4]);
               }
            }

            if(this.field927 != null) {
               for(var4 = 0; var4 < this.field927.length; ++var4) {
                  var3.method2240(this.field927[var4], this.field936[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "-1576835327"
   )
   public final NPCComposition method810() {
      int var1 = -1;
      if(this.field940 != -1) {
         var1 = class153.method3184(this.field940);
      } else if(this.field941 != -1) {
         var1 = class179.widgetSettings[this.field941];
      }

      return var1 >= 0 && var1 < this.field923.length && this.field923[var1] != -1?ObjectComposition.getNpcDefinition(this.field923[var1]):null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1012834394"
   )
   public boolean method811() {
      if(this.field923 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field940 != -1) {
            var1 = class153.method3184(this.field940);
         } else if(this.field941 != -1) {
            var1 = class179.widgetSettings[this.field941];
         }

         return var1 >= 0 && var1 < this.field923.length && this.field923[var1] != -1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "11288438"
   )
   void method814() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1336309726"
   )
   public final Model method822(Sequence var1, int var2, Sequence var3, int var4) {
      if(null != this.field923) {
         NPCComposition var12 = this.method810();
         return var12 == null?null:var12.method822(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.models.length; ++var10) {
               if(!class145.field2245.method3351(this.models[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2284(class145.field2245, this.models[var9], 0);
            }

            ModelData var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new ModelData(var8, var8.length);
            }

            if(null != this.field925) {
               for(var9 = 0; var9 < this.field925.length; ++var9) {
                  var7.method2239(this.field925[var9], this.field926[var9]);
               }
            }

            if(this.field927 != null) {
               for(var9 = 0; var9 < this.field927.length; ++var9) {
                  var7.method2240(this.field927[var9], this.field936[var9]);
               }
            }

            var5 = var7.method2247(64 + this.field930, this.field939 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(null != var1 && var3 != null) {
            var11 = var1.method906(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method903(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method903(var5, var4);
         } else {
            var11 = var5.method2358(true);
         }

         if(this.field933 != 128 || this.field917 != 128) {
            var11.method2335(this.field933, this.field917, this.field933);
         }

         return var11;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "6074"
   )
   public static int method835(String var0) {
      return var0.length() + 2;
   }
}

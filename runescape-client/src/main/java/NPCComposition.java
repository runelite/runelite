import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("y")
   @Export("models")
   int[] models;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1877128441
   )
   int field895 = 128;
   @ObfuscatedName("c")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1315819149
   )
   @Export("id")
   public int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1462314649
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1245739685
   )
   public int field899 = 1;
   @ObfuscatedName("aa")
   public boolean field900 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 865687187
   )
   public int field901 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1004392563
   )
   public int field902 = -1;
   @ObfuscatedName("f")
   static NodeCache field903 = new NodeCache(64);
   @ObfuscatedName("a")
   short[] field904;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1618341397
   )
   public int field905 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 844136937
   )
   public int field906 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 810827319
   )
   public int field907 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -53196635
   )
   public int field908 = -1;
   @ObfuscatedName("w")
   short[] field909;
   @ObfuscatedName("i")
   short[] field910;
   @ObfuscatedName("r")
   short[] field911;
   @ObfuscatedName("u")
   int[] field912;
   @ObfuscatedName("j")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("z")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("n")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("k")
   static class170 field916;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -251743219
   )
   int field917 = 128;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1893709713
   )
   public int field918 = 32;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 356731799
   )
   int field919 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2099745655
   )
   int field920 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1027365467
   )
   int field921 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -126521043
   )
   public int field922 = -1;
   @ObfuscatedName("at")
   public int[] field923;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1253205145
   )
   int field924 = -1;
   @ObfuscatedName("ay")
   public boolean field926 = true;
   @ObfuscatedName("ag")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1350580929
   )
   public int field928 = -1;
   @ObfuscatedName("o")
   @Export("isVisible")
   public boolean isVisible = false;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-52"
   )
   void method797(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method798(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method798(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2571();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method2691();
         }
      } else if(var2 == 2) {
         this.name = var1.method2579();
      } else if(var2 == 12) {
         this.field899 = var1.method2571();
      } else if(var2 == 13) {
         this.field902 = var1.method2691();
      } else if(var2 == 14) {
         this.field905 = var1.method2691();
      } else if(var2 == 15) {
         this.field901 = var1.method2691();
      } else if(var2 == 16) {
         this.field922 = var1.method2691();
      } else if(var2 == 17) {
         this.field905 = var1.method2691();
         this.field906 = var1.method2691();
         this.field907 = var1.method2691();
         this.field908 = var1.method2691();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2579();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2571();
         this.field909 = new short[var3];
         this.field910 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field909[var4] = (short)var1.method2691();
            this.field910[var4] = (short)var1.method2691();
         }
      } else if(var2 == 41) {
         var3 = var1.method2571();
         this.field911 = new short[var3];
         this.field904 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field911[var4] = (short)var1.method2691();
            this.field904[var4] = (short)var1.method2691();
         }
      } else if(var2 == 60) {
         var3 = var1.method2571();
         this.field912 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field912[var4] = var1.method2691();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method2691();
      } else if(var2 == 97) {
         this.field895 = var1.method2691();
      } else if(var2 == 98) {
         this.field917 = var1.method2691();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field919 = var1.method2572();
      } else if(var2 == 101) {
         this.field920 = var1.method2572() * 5;
      } else if(var2 == 102) {
         this.field928 = var1.method2691();
      } else if(var2 == 103) {
         this.field918 = var1.method2691();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field926 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field900 = true;
         }
      } else {
         this.field924 = var1.method2691();
         if(this.field924 == '\uffff') {
            this.field924 = -1;
         }

         this.field921 = var1.method2691();
         if(this.field921 == '\uffff') {
            this.field921 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.method2691();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.method2571();
         this.field923 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field923[var5] = var1.method2691();
            if(this.field923[var5] == '\uffff') {
               this.field923[var5] = -1;
            }
         }

         this.field923[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "497188346"
   )
   public final ModelData method800() {
      if(this.field923 != null) {
         NPCComposition var1 = this.method801();
         return var1 == null?null:var1.method800();
      } else if(this.field912 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var6 = 0; var6 < this.field912.length; ++var6) {
            if(!class22.field584.method3282(this.field912[var6], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field912.length];

            for(int var7 = 0; var7 < this.field912.length; ++var7) {
               var2[var7] = ModelData.method2274(class22.field584, this.field912[var7], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(null != this.field909) {
               for(var4 = 0; var4 < this.field909.length; ++var4) {
                  var3.method2285(this.field909[var4], this.field910[var4]);
               }
            }

            if(this.field911 != null) {
               for(var4 = 0; var4 < this.field911.length; ++var4) {
                  var3.method2286(this.field911[var4], this.field904[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "62760801"
   )
   public final NPCComposition method801() {
      int var1 = -1;
      if(this.field924 != -1) {
         var1 = class219.method3992(this.field924);
      } else if(this.field921 != -1) {
         var1 = class179.widgetSettings[this.field921];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field923.length - 1) {
         var2 = this.field923[var1];
      } else {
         var2 = this.field923[this.field923.length - 1];
      }

      return var2 != -1?class110.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1776737074"
   )
   void method802() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1282465899"
   )
   public final Model method808(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field923 != null) {
         NPCComposition var12 = this.method801();
         return null == var12?null:var12.method808(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!class22.field584.method3282(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2274(class22.field584, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(null != this.field909) {
               for(var9 = 0; var9 < this.field909.length; ++var9) {
                  var11.method2285(this.field909[var9], this.field910[var9]);
               }
            }

            if(this.field911 != null) {
               for(var9 = 0; var9 < this.field911.length; ++var9) {
                  var11.method2286(this.field911[var9], this.field904[var9]);
               }
            }

            var5 = var11.method2293(this.field919 + 64, 850 + this.field920, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && null != var3) {
            var10 = var1.method917(var5, var2, var3, var4);
         } else if(null != var1) {
            var10 = var1.method898(var5, var2);
         } else if(null != var3) {
            var10 = var3.method898(var5, var4);
         } else {
            var10 = var5.method2402(true);
         }

         if(this.field895 != 128 || this.field917 != 128) {
            var10.method2376(this.field895, this.field917, this.field895);
         }

         return var10;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "116087903"
   )
   public boolean method823() {
      if(this.field923 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field924 != -1) {
            var1 = class219.method3992(this.field924);
         } else if(this.field921 != -1) {
            var1 = class179.widgetSettings[this.field921];
         }

         return var1 >= 0 && var1 < this.field923.length?this.field923[var1] != -1:this.field923[this.field923.length - 1] != -1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "19066"
   )
   static final int method829(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(LActor;S)V",
      garbageValue = "512"
   )
   static final void method830(Actor var0) {
      int var1 = var0.field871 - Client.gameCycle;
      int var2 = var0.field841 * 64 + var0.field867 * 128;
      int var3 = var0.field841 * 64 + var0.field869 * 128;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field883 = 0;
      var0.field876 = var0.field873;
   }

   @ObfuscatedName("f")
   public static String method831(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class165.field2690[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILclass137;Lclass171;B)V",
      garbageValue = "4"
   )
   static void method832(int var0, class137 var1, class171 var2) {
      byte[] var3 = null;
      Deque var4 = class173.field2759;
      synchronized(class173.field2759) {
         for(class172 var5 = (class172)class173.field2759.method3864(); var5 != null; var5 = (class172)class173.field2759.method3851()) {
            if(var5.hash == (long)var0 && var1 == var5.field2748 && var5.field2749 == 0) {
               var3 = var5.field2747;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3368(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2903(var0);
         var2.method3368(var1, var0, var8, true);
      }
   }
}

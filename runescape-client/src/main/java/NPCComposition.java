import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -651291941
   )
   int field907 = 0;
   @ObfuscatedName("g")
   public static class170 field908;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1647841037
   )
   int field909 = 128;
   @ObfuscatedName("e")
   @Export("npcModelCache")
   static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("i")
   short[] field911;
   @ObfuscatedName("s")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1754332403
   )
   public int field913 = 1;
   @ObfuscatedName("u")
   @Export("models")
   int[] models;
   @ObfuscatedName("n")
   int[] field915;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1775259135
   )
   int field916 = 128;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1055781361
   )
   public int field917 = -1;
   @ObfuscatedName("c")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 505418297
   )
   public int field919 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1732609405
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("l")
   public static class170 field921;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1285448113
   )
   public int field922 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1343466873
   )
   public int field923 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -965663117
   )
   @Export("id")
   public int id;
   @ObfuscatedName("f")
   short[] field925;
   @ObfuscatedName("v")
   short[] field926;
   @ObfuscatedName("j")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -497760511
   )
   public int field928 = -1;
   @ObfuscatedName("r")
   static NodeCache field929 = new NodeCache(64);
   @ObfuscatedName("z")
   short[] field930;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -75050061
   )
   public int field931 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1245172423
   )
   public int field932 = -1;
   @ObfuscatedName("x")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1746572411
   )
   int field934 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1678730625
   )
   public int field935 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1413058687
   )
   public int field936 = 32;
   @ObfuscatedName("am")
   public int[] field937;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1039221475
   )
   int field938 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1287887143
   )
   int field939 = -1;
   @ObfuscatedName("ak")
   public boolean field940 = true;
   @ObfuscatedName("ag")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("af")
   public boolean field942 = false;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1225576323"
   )
   void method815() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1543275936"
   )
   public final Model method818(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.field937 != null) {
         NPCComposition var11 = this.method820();
         return var11 == null?null:var11.method818(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field908.method3453(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var12 = new ModelData[this.models.length];

            int var8;
            for(var8 = 0; var8 < this.models.length; ++var8) {
               var12[var8] = ModelData.method2369(field908, this.models[var8], 0);
            }

            ModelData var9;
            if(var12.length == 1) {
               var9 = var12[0];
            } else {
               var9 = new ModelData(var12, var12.length);
            }

            if(null != this.field925) {
               for(var8 = 0; var8 < this.field925.length; ++var8) {
                  var9.method2305(this.field925[var8], this.field930[var8]);
               }
            }

            if(this.field911 != null) {
               for(var8 = 0; var8 < this.field911.length; ++var8) {
                  var9.method2306(this.field911[var8], this.field926[var8]);
               }
            }

            var5 = var9.method2321(64 + this.field907, this.field934 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(null != var1 && var3 != null) {
            var10 = var1.method914(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method943(var5, var2);
         } else if(null != var3) {
            var10 = var3.method943(var5, var4);
         } else {
            var10 = var5.method2399(true);
         }

         if(this.field909 != 128 || this.field916 != 128) {
            var10.method2404(this.field909, this.field916, this.field909);
         }

         return var10;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "44"
   )
   public final ModelData method819() {
      if(null != this.field937) {
         NPCComposition var5 = this.method820();
         return var5 == null?null:var5.method819();
      } else if(this.field915 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field915.length; ++var2) {
            if(!field908.method3453(this.field915[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field915.length];

            for(int var3 = 0; var3 < this.field915.length; ++var3) {
               var6[var3] = ModelData.method2369(field908, this.field915[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(null != this.field925) {
               for(var4 = 0; var4 < this.field925.length; ++var4) {
                  var7.method2305(this.field925[var4], this.field930[var4]);
               }
            }

            if(this.field911 != null) {
               for(var4 = 0; var4 < this.field911.length; ++var4) {
                  var7.method2306(this.field911[var4], this.field926[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "308631255"
   )
   public final NPCComposition method820() {
      int var1 = -1;
      if(this.field938 != -1) {
         var1 = class54.method1164(this.field938);
      } else if(this.field939 != -1) {
         var1 = class179.widgetSettings[this.field939];
      }

      return var1 >= 0 && var1 < this.field937.length && this.field937[var1] != -1?class16.getNpcDefinition(this.field937[var1]):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "3"
   )
   void method833(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2633();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.method2635();
         }
      } else if(var2 == 2) {
         this.name = var1.method2663();
      } else if(var2 == 12) {
         this.field913 = var1.method2633();
      } else if(var2 == 13) {
         this.field931 = var1.method2635();
      } else if(var2 == 14) {
         this.field919 = var1.method2635();
      } else if(var2 == 15) {
         this.field928 = var1.method2635();
      } else if(var2 == 16) {
         this.field923 = var1.method2635();
      } else if(var2 == 17) {
         this.field919 = var1.method2635();
         this.field917 = var1.method2635();
         this.field932 = var1.method2635();
         this.field922 = var1.method2635();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2663();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2633();
         this.field925 = new short[var3];
         this.field930 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field925[var4] = (short)var1.method2635();
            this.field930[var4] = (short)var1.method2635();
         }
      } else if(var2 == 41) {
         var3 = var1.method2633();
         this.field911 = new short[var3];
         this.field926 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field911[var4] = (short)var1.method2635();
            this.field926[var4] = (short)var1.method2635();
         }
      } else if(var2 == 60) {
         var3 = var1.method2633();
         this.field915 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field915[var4] = var1.method2635();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.method2635();
      } else if(var2 == 97) {
         this.field909 = var1.method2635();
      } else if(var2 == 98) {
         this.field916 = var1.method2635();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field907 = var1.method2634();
      } else if(var2 == 101) {
         this.field934 = var1.method2634() * 5;
      } else if(var2 == 102) {
         this.field935 = var1.method2635();
      } else if(var2 == 103) {
         this.field936 = var1.method2635();
      } else if(var2 == 106) {
         this.field938 = var1.method2635();
         if(this.field938 == '\uffff') {
            this.field938 = -1;
         }

         this.field939 = var1.method2635();
         if(this.field939 == '\uffff') {
            this.field939 = -1;
         }

         var3 = var1.method2633();
         this.field937 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field937[var4] = var1.method2635();
            if(this.field937[var4] == '\uffff') {
               this.field937[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field940 = false;
      } else if(var2 == 109) {
         this.isClickable = false;
      } else if(var2 == 111) {
         this.field942 = true;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1602304248"
   )
   void method838(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method833(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "-1054819598"
   )
   public static class52 method843(int var0) {
      class52 var1 = (class52)class52.field1157.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class52.field1152.method3411(8, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1124(new Buffer(var2));
         }

         class52.field1157.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1673062880"
   )
   public boolean method844() {
      if(this.field937 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field938 != -1) {
            var1 = class54.method1164(this.field938);
         } else if(this.field939 != -1) {
            var1 = class179.widgetSettings[this.field939];
         }

         return var1 >= 0 && var1 < this.field937.length && this.field937[var1] != -1;
      }
   }
}

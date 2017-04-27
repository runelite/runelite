import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1507919085
   )
   public int field3033 = -1;
   @ObfuscatedName("c")
   public static IndexDataBase field3034;
   @ObfuscatedName("n")
   public static NodeCache field3035 = new NodeCache(64);
   @ObfuscatedName("q")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1405080953
   )
   @Export("id")
   public int id;
   @ObfuscatedName("d")
   public static IndexDataBase field3038;
   @ObfuscatedName("ao")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("z")
   @Export("models")
   int[] models;
   @ObfuscatedName("l")
   int[] field3041;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -424976029
   )
   public int field3042 = 1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1894280515
   )
   public int field3043 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -543115347
   )
   int field3044 = 128;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1147105331
   )
   public int field3045 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1114695449
   )
   int field3046 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 798432575
   )
   public int field3047 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1986049793
   )
   public int field3048 = 32;
   @ObfuscatedName("j")
   short[] field3049;
   @ObfuscatedName("i")
   short[] field3050;
   @ObfuscatedName("a")
   short[] field3051;
   @ObfuscatedName("x")
   short[] field3052;
   @ObfuscatedName("h")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("b")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("p")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1927872857
   )
   int field3056 = 128;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1537175821
   )
   public int field3057 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1897348339
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 526120715
   )
   int field3059 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1840141441
   )
   int field3060 = 0;
   @ObfuscatedName("aj")
   public boolean field3061 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 292706655
   )
   public int field3062 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1676715729
   )
   int field3063 = -1;
   @ObfuscatedName("y")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1908612155
   )
   public int field3065 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -391605143
   )
   public int field3066 = -1;
   @ObfuscatedName("ay")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("ae")
   public boolean field3068 = false;
   @ObfuscatedName("aq")
   class142 field3069;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method3800() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-29"
   )
   public boolean method3802() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3063 != -1) {
            var1 = class59.method1140(this.field3063);
         } else if(this.field3046 != -1) {
            var1 = class167.widgetSettings[this.field3046];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "1930712924"
   )
   public final NPCComposition method3804() {
      int var1 = -1;
      if(this.field3063 != -1) {
         var1 = class59.method1140(this.field3063);
      } else if(this.field3046 != -1) {
         var1 = class167.widgetSettings[this.field3046];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?Widget.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "-1276933557"
   )
   public static BufferProvider method3805(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1213065191"
   )
   public int method3806(int var1, int var2) {
      return IndexData.method3408(this.field3069, var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "97"
   )
   public final Model method3813(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method3804();
         return var12 == null?null:var12.method3813(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3034.method3297(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1479(field3034, this.models[var9], 0);
            }

            ModelData var10;
            if(var8.length == 1) {
               var10 = var8[0];
            } else {
               var10 = new ModelData(var8, var8.length);
            }

            if(this.field3049 != null) {
               for(var9 = 0; var9 < this.field3049.length; ++var9) {
                  var10.method1491(this.field3049[var9], this.field3050[var9]);
               }
            }

            if(this.field3051 != null) {
               for(var9 = 0; var9 < this.field3051.length; ++var9) {
                  var10.method1492(this.field3051[var9], this.field3052[var9]);
               }
            }

            var5 = var10.method1502(this.field3059 + 64, this.field3060 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method3875(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method3862(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method3862(var5, var4);
         } else {
            var11 = var5.method1571(true);
         }

         if(this.field3056 != 128 || this.field3044 != 128) {
            var11.method1582(this.field3056, this.field3044, this.field3056);
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1652923500"
   )
   void method3825(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3835(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1132474475"
   )
   public String method3831(int var1, String var2) {
      return class164.method3100(this.field3069, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "44437884"
   )
   public final ModelData method3832() {
      if(this.configs != null) {
         NPCComposition var1 = this.method3804();
         return var1 == null?null:var1.method3832();
      } else if(this.field3041 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3041.length; ++var2) {
            if(!field3034.method3297(this.field3041[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3041.length];

            for(int var3 = 0; var3 < this.field3041.length; ++var3) {
               var6[var3] = ModelData.method1479(field3034, this.field3041[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field3049 != null) {
               for(var4 = 0; var4 < this.field3049.length; ++var4) {
                  var7.method1491(this.field3049[var4], this.field3050[var4]);
               }
            }

            if(this.field3051 != null) {
               for(var4 = 0; var4 < this.field3051.length; ++var4) {
                  var7.method1492(this.field3051[var4], this.field3052[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-542339317"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3087.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3098.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method3859(new Buffer(var2));
         }

         var1.method3867();
         Sequence.field3087.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1413650826"
   )
   void method3835(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.field3042 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3047 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3065 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3043 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3066 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3065 = var1.readUnsignedShort();
         this.field3033 = var1.readUnsignedShort();
         this.field3062 = var1.readUnsignedShort();
         this.field3057 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3049 = new short[var3];
         this.field3050 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3049[var4] = (short)var1.readUnsignedShort();
            this.field3050[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3051 = new short[var3];
         this.field3052 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3051[var4] = (short)var1.readUnsignedShort();
            this.field3052[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3041 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3041[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3056 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3044 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3059 = var1.readByte();
      } else if(var2 == 101) {
         this.field3060 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3045 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3048 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3061 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3068 = true;
         } else if(var2 == 249) {
            this.field3069 = class180.method3283(var1, this.field3069);
         }
      } else {
         this.field3063 = var1.readUnsignedShort();
         if(this.field3063 == '\uffff') {
            this.field3063 = -1;
         }

         this.field3046 = var1.readUnsignedShort();
         if(this.field3046 == '\uffff') {
            this.field3046 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }
}

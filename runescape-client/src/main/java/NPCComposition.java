import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3550;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3559;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3570;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -735733003
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("aw")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("v")
   @Export("name")
   public String name;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1864133047
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("d")
   int[] field3557;
   @ObfuscatedName("e")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1075314869
   )
   @Export("id")
   public int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1612692495
   )
   public int field3555;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -516850719
   )
   public int field3549;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2134065983
   )
   public int field3573;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 252543449
   )
   public int field3585;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1324924061
   )
   public int field3560;
   @ObfuscatedName("k")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 594791701
   )
   int field3572;
   @ObfuscatedName("h")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("c")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1522451427
   )
   int field3554;
   @ObfuscatedName("j")
   short[] field3567;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 107996507
   )
   public int field3578;
   @ObfuscatedName("b")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("y")
   short[] field3568;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -288799547
   )
   public int field3563;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 622151053
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("f")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 641426611
   )
   public int field3564;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 928686831
   )
   int field3575;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1586073145
   )
   int field3576;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 860585849
   )
   public int field3577;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -272672029
   )
   public int field3562;
   @ObfuscatedName("ao")
   public boolean field3582;
   @ObfuscatedName("aq")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("ax")
   public boolean field3584;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3555 = 1;
      this.field3549 = -1;
      this.field3585 = -1;
      this.field3560 = -1;
      this.field3573 = -1;
      this.field3578 = -1;
      this.field3563 = -1;
      this.field3564 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3572 = 128;
      this.field3554 = 128;
      this.isVisible = false;
      this.field3575 = 0;
      this.field3576 = 0;
      this.field3577 = -1;
      this.field3562 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3582 = true;
      this.isClickable = true;
      this.field3584 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lia;",
      garbageValue = "-68"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class89.method1732(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class211.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class17.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "-2123316996"
   )
   void method4727(Buffer var1, int var2) {
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
         this.field3555 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3549 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3573 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3585 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3560 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3573 = var1.readUnsignedShort();
         this.field3578 = var1.readUnsignedShort();
         this.field3563 = var1.readUnsignedShort();
         this.field3564 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.colors = new short[var3];
         this.modifiedColors = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.colors[var4] = (short)var1.readUnsignedShort();
            this.modifiedColors[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3567 = new short[var3];
         this.field3568 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3567[var4] = (short)var1.readUnsignedShort();
            this.field3568[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3557 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3557[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3572 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3554 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3575 = var1.readByte();
      } else if(var2 == 101) {
         this.field3576 = var1.readByte();
      } else if(var2 == 102) {
         this.field3577 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3562 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3582 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3584 = true;
         } else if(var2 == 249) {
            this.field3570 = FileOnDisk.method2427(var1, this.field3570);
         }
      } else {
         this.varpIndex = var1.readUnsignedShort();
         if(this.varpIndex == 65535) {
            this.varpIndex = -1;
         }

         this.varp32Index = var1.readUnsignedShort();
         if(this.varp32Index == 65535) {
            this.varp32Index = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == 65535) {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ldo;",
      garbageValue = "-249690594"
   )
   public final ModelData method4752() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4752();
      } else if(this.field3557 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3557.length; ++var2) {
            if(!field3550.method4192(this.field3557[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3557.length];

            for(int var3 = 0; var3 < this.field3557.length; ++var3) {
               var6[var3] = ModelData.method2534(field3550, this.field3557[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.colors != null) {
               for(var4 = 0; var4 < this.colors.length; ++var4) {
                  var7.recolor(this.colors[var4], this.modifiedColors[var4]);
               }
            }

            if(this.field3567 != null) {
               for(var4 = 0; var4 < this.field3567.length; ++var4) {
                  var7.method2495(this.field3567[var4], this.field3568[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljt;ILjt;IB)Leh;",
      garbageValue = "1"
   )
   public final Model method4728(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4728(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3550.method4192(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2534(field3550, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.colors != null) {
               for(var9 = 0; var9 < this.colors.length; ++var9) {
                  var11.recolor(this.colors[var9], this.modifiedColors[var9]);
               }
            }

            if(this.field3567 != null) {
               for(var9 = 0; var9 < this.field3567.length; ++var9) {
                  var11.method2495(this.field3567[var9], this.field3568[var9]);
               }
            }

            var5 = var11.light(this.field3575 + 64, this.field3576 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4784(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4779(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4779(var5, var4);
         } else {
            var10 = var5.method2628(true);
         }

         if(this.field3572 != 128 || this.field3554 != 128) {
            var10.method2624(this.field3572, this.field3554, this.field3572);
         }

         return var10;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1267998741"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "385842477"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4727(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1807752395"
   )
   public boolean method4731() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class89.method1732(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class211.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-485641132"
   )
   public int method4732(int var1, int var2) {
      return class227.method4159(this.field3570, var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1064732088"
   )
   public String method4751(int var1, String var2) {
      return class204.method3902(this.field3570, var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Ljt;",
      garbageValue = "70"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "4"
   )
   public static int method4759(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }
}

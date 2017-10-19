import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class45 extends class28 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1864419113
   )
   int field603;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 674352101
   )
   int field604;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1227908357
   )
   int field602;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1192514489
   )
   int field605;

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-354967826"
   )
   int method649() {
      return this.field602;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-55"
   )
   boolean method633(int var1, int var2) {
      return var1 < this.field602 * 8?false:(var2 < this.field605 * 8?false:(var1 >= this.field602 * 8 + 8?false:var2 < this.field605 * 8 + 8));
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-234704773"
   )
   int method631() {
      return this.field605;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;Lfz;I)V",
      garbageValue = "-474858510"
   )
   void method626(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field516.field515) {
         throw new IllegalStateException("");
      } else {
         super.field419 = var2.readUnsignedByte();
         super.field415 = var2.readUnsignedByte();
         super.field423 = var2.readUnsignedShort();
         super.field416 = var2.readUnsignedShort();
         this.field604 = var2.readUnsignedByte();
         this.field603 = var2.readUnsignedByte();
         super.field420 = var2.readUnsignedShort();
         super.field418 = var2.readUnsignedShort();
         this.field602 = var2.readUnsignedByte();
         this.field605 = var2.readUnsignedByte();
         super.field415 = Math.min(super.field415, 4);
         super.field421 = new short[1][64][64];
         super.field417 = new short[super.field415][64][64];
         super.field422 = new byte[super.field415][64][64];
         super.field424 = new byte[super.field415][64][64];
         super.field425 = new class31[super.field415][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field506.field507) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field420 && var5 == super.field418 && var6 == this.field602 && var7 == this.field605) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method239(var8 + this.field602 * 8, var9 + this.field605 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   int method628() {
      return this.field604;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1953485283"
   )
   int method624() {
      return this.field603;
   }

   public int hashCode() {
      return super.field420 | super.field418 << 8 | this.field602 << 16 | this.field605 << 24;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field420 == super.field420 && super.field418 == var2.field418?var2.field602 == this.field602 && this.field605 == var2.field605:false;
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lhj;I)V",
      garbageValue = "1204036324"
   )
   static void method647(Widget var0) {
      if(var0.loopCycle == Client.field1057) {
         Client.field1119[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-3167365"
   )
   static final void method630(int var0) {
      CombatInfoListHolder.method1688();

      for(class80 var1 = (class80)class80.field1323.getFront(); var1 != null; var1 = (class80)class80.field1323.getNext()) {
         if(var1.field1325 != null) {
            var1.method1601();
         }
      }

      int var4 = Friend.method1084(var0).configType;
      if(var4 != 0) {
         int var2 = class211.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1149) {
               if(Client.field1149 == 0 && Client.field1150 != -1) {
                  CombatInfoListHolder.method1691(class37.indexTrack1, Client.field1150, 0, var3, false);
                  Client.field1151 = false;
               } else if(var3 == 0) {
                  class152.method2974();
                  Client.field1151 = false;
               } else {
                  GrandExchangeOffer.method115(var3);
               }

               Client.field1149 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1152 = 127;
            }

            if(var2 == 1) {
               Client.field1152 = 96;
            }

            if(var2 == 2) {
               Client.field1152 = 64;
            }

            if(var2 == 3) {
               Client.field1152 = 32;
            }

            if(var2 == 4) {
               Client.field1152 = 0;
            }
         }

         if(var4 == 5) {
            Client.field1051 = var2;
         }

         if(var4 == 6) {
            Client.field1076 = var2;
         }

         if(var4 == 9) {
            Client.field1077 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field922 = 127;
            }

            if(var2 == 1) {
               Client.field922 = 96;
            }

            if(var2 == 2) {
               Client.field922 = 64;
            }

            if(var2 == 3) {
               Client.field922 = 32;
            }

            if(var2 == 4) {
               Client.field922 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1082 = var2 & 65535;
         }

         if(var4 == 18) {
            Client.field948 = (class89)class29.forOrdinal(Occluder.method2921(), var2);
            if(Client.field948 == null) {
               Client.field948 = class89.field1405;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field1043 = -1;
            } else {
               Client.field1043 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            Client.field949 = (class89)class29.forOrdinal(Occluder.method2921(), var2);
            if(Client.field949 == null) {
               Client.field949 = class89.field1405;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1780688822"
   )
   public static String method653(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = '*';
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-255236574"
   )
   static void method642(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method642(var0, var1, var2, var5 - 1);
         method642(var0, var1, var5 + 1, var3);
      }

   }
}

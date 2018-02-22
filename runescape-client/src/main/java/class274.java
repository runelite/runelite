import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public class class274 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field3515;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field3501;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field3497;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3498;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3499;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3500;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -539178225
   )
   int field3513;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 448726047
   )
   public int field3502;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1105994627
   )
   public int field3516;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 309634109
   )
   int field3504;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1180374089
   )
   int field3505;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1326344031
   )
   int field3495;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1958190913
   )
   int field3507;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1297075669
   )
   public int field3509;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1426250373
   )
   public int field3496;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1945368405
   )
   public int field3510;
   @ObfuscatedName("z")
   String field3511;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -628023171
   )
   public int field3512;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1986155677
   )
   public int field3503;
   @ObfuscatedName("n")
   public int[] field3514;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1538637213
   )
   int field3506;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 532945603
   )
   int field3508;

   static {
      field3498 = new NodeCache(64);
      field3499 = new NodeCache(64);
      field3500 = new NodeCache(20);
   }

   class274() {
      this.field3513 = -1;
      this.field3502 = 16777215;
      this.field3516 = 70;
      this.field3504 = -1;
      this.field3505 = -1;
      this.field3495 = -1;
      this.field3507 = -1;
      this.field3509 = 0;
      this.field3496 = 0;
      this.field3510 = -1;
      this.field3511 = "";
      this.field3512 = -1;
      this.field3503 = 0;
      this.field3506 = -1;
      this.field3508 = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1786934498"
   )
   void method4918(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4946(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "1651101921"
   )
   void method4946(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3513 = var1.method3732();
      } else if(var2 == 2) {
         this.field3502 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3504 = var1.method3732();
      } else if(var2 == 4) {
         this.field3495 = var1.method3732();
      } else if(var2 == 5) {
         this.field3505 = var1.method3732();
      } else if(var2 == 6) {
         this.field3507 = var1.method3732();
      } else if(var2 == 7) {
         this.field3509 = var1.readShort();
      } else if(var2 == 8) {
         this.field3511 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3516 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3496 = var1.readShort();
      } else if(var2 == 11) {
         this.field3510 = 0;
      } else if(var2 == 12) {
         this.field3512 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3503 = var1.readShort();
      } else if(var2 == 14) {
         this.field3510 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3506 = var1.readUnsignedShort();
         if(this.field3506 == 65535) {
            this.field3506 = -1;
         }

         this.field3508 = var1.readUnsignedShort();
         if(this.field3508 == 65535) {
            this.field3508 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3514 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3514[var5] = var1.readUnsignedShort();
            if(this.field3514[var5] == 65535) {
               this.field3514[var5] = -1;
            }
         }

         this.field3514[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljs;",
      garbageValue = "-1823413579"
   )
   public final class274 method4919() {
      int var1 = -1;
      if(this.field3506 != -1) {
         var1 = class28.getVarbit(this.field3506);
      } else if(this.field3508 != -1) {
         var1 = class231.widgetSettings[this.field3508];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3514.length - 1) {
         var2 = this.field3514[var1];
      } else {
         var2 = this.field3514[this.field3514.length - 1];
      }

      return var2 != -1?NPC.method1847(var2):null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-908860008"
   )
   public String method4920(int var1) {
      String var2 = this.field3511;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + AbstractByteBuffer.method3809(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Llm;",
      garbageValue = "1739182673"
   )
   public SpritePixels method4921() {
      if(this.field3504 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3499.get((long)this.field3504);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class19.method165(field3501, this.field3504, 0);
            if(var1 != null) {
               field3499.put(var1, (long)this.field3504);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Llm;",
      garbageValue = "-1377217063"
   )
   public SpritePixels method4938() {
      if(this.field3505 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3499.get((long)this.field3505);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class19.method165(field3501, this.field3505, 0);
            if(var1 != null) {
               field3499.put(var1, (long)this.field3505);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Llm;",
      garbageValue = "1599374745"
   )
   public SpritePixels method4923() {
      if(this.field3495 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3499.get((long)this.field3495);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class19.method165(field3501, this.field3495, 0);
            if(var1 != null) {
               field3499.put(var1, (long)this.field3495);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Llm;",
      garbageValue = "1646702868"
   )
   public SpritePixels method4937() {
      if(this.field3507 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3499.get((long)this.field3507);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class19.method165(field3501, this.field3507, 0);
            if(var1 != null) {
               field3499.put(var1, (long)this.field3507);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lkt;",
      garbageValue = "-1537680330"
   )
   public Font method4925() {
      if(this.field3513 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3500.get((long)this.field3513);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameSocket.method3379(field3501, field3497, this.field3513, 0);
            if(var1 != null) {
               field3500.put(var1, (long)this.field3513);
            }

            return var1;
         }
      }
   }
}

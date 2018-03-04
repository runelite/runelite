import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class281 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static IndexDataBase field3577;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static IndexDataBase field3564;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static NodeCache field3565;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static NodeCache field3566;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static NodeCache field3567;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1264868619
   )
   int field3570;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1106291823
   )
   public int field3569;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -415982669
   )
   public int field3572;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1361862211
   )
   int field3574;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1125744137
   )
   int field3571;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -602972889
   )
   int field3563;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2132790387
   )
   int field3576;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -412027449
   )
   public int field3584;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 87643623
   )
   public int field3578;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -237956019
   )
   public int field3586;
   @ObfuscatedName("l")
   String field3573;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 390352783
   )
   public int field3581;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1563171363
   )
   public int field3582;
   @ObfuscatedName("o")
   public int[] field3583;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1804666509
   )
   int field3580;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1117511109
   )
   int field3579;

   static {
      field3565 = new NodeCache(64);
      field3566 = new NodeCache(64);
      field3567 = new NodeCache(20);
   }

   class281() {
      this.field3570 = -1;
      this.field3569 = 16777215;
      this.field3572 = 70;
      this.field3574 = -1;
      this.field3571 = -1;
      this.field3563 = -1;
      this.field3576 = -1;
      this.field3584 = 0;
      this.field3578 = 0;
      this.field3586 = -1;
      this.field3573 = "";
      this.field3581 = -1;
      this.field3582 = 0;
      this.field3580 = -1;
      this.field3579 = -1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "2122680314"
   )
   void method5080(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method5081(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "-27"
   )
   void method5081(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3570 = var1.method3617();
      } else if(var2 == 2) {
         this.field3569 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3574 = var1.method3617();
      } else if(var2 == 4) {
         this.field3563 = var1.method3617();
      } else if(var2 == 5) {
         this.field3571 = var1.method3617();
      } else if(var2 == 6) {
         this.field3576 = var1.method3617();
      } else if(var2 == 7) {
         this.field3584 = var1.readShort();
      } else if(var2 == 8) {
         this.field3573 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3572 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3578 = var1.readShort();
      } else if(var2 == 11) {
         this.field3586 = 0;
      } else if(var2 == 12) {
         this.field3581 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3582 = var1.readShort();
      } else if(var2 == 14) {
         this.field3586 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3580 = var1.readUnsignedShort();
         if(this.field3580 == 65535) {
            this.field3580 = -1;
         }

         this.field3579 = var1.readUnsignedShort();
         if(this.field3579 == 65535) {
            this.field3579 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3583 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3583[var5] = var1.readUnsignedShort();
            if(this.field3583[var5] == 65535) {
               this.field3583[var5] = -1;
            }
         }

         this.field3583[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljb;",
      garbageValue = "-905487723"
   )
   public final class281 method5082() {
      int var1 = -1;
      if(this.field3580 != -1) {
         var1 = class57.getVarbit(this.field3580);
      } else if(this.field3579 != -1) {
         var1 = class237.widgetSettings[this.field3579];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3583.length - 1) {
         var2 = this.field3583[var1];
      } else {
         var2 = this.field3583[this.field3583.length - 1];
      }

      return var2 != -1?Permission.method4651(var2):null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-311944022"
   )
   public String method5083(int var1) {
      String var2 = this.field3573;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lly;",
      garbageValue = "-118"
   )
   public SpritePixels method5084() {
      if(this.field3574 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3566.get((long)this.field3574);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class45.method640(TotalQuantityComparator.field304, this.field3574, 0);
            if(var1 != null) {
               field3566.put(var1, (long)this.field3574);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Lly;",
      garbageValue = "-29899"
   )
   public SpritePixels method5085() {
      if(this.field3571 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3566.get((long)this.field3571);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class45.method640(TotalQuantityComparator.field304, this.field3571, 0);
            if(var1 != null) {
               field3566.put(var1, (long)this.field3571);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lly;",
      garbageValue = "-1718173749"
   )
   public SpritePixels method5086() {
      if(this.field3563 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3566.get((long)this.field3563);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class45.method640(TotalQuantityComparator.field304, this.field3563, 0);
            if(var1 != null) {
               field3566.put(var1, (long)this.field3563);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lly;",
      garbageValue = "-1653368318"
   )
   public SpritePixels method5097() {
      if(this.field3576 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3566.get((long)this.field3576);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class45.method640(TotalQuantityComparator.field304, this.field3576, 0);
            if(var1 != null) {
               field3566.put(var1, (long)this.field3576);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lkw;",
      garbageValue = "1787465487"
   )
   public Font method5088() {
      if(this.field3570 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3567.get((long)this.field3570);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WallObject.method3133(TotalQuantityComparator.field304, field3564, this.field3570, 0);
            if(var1 != null) {
               field3567.put(var1, (long)this.field3570);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1576738237"
   )
   static String method5109(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class25.sessionToken != null) {
         var3 = "/p=" + class25.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + ScriptState.field759 + var3 + "/";
   }
}

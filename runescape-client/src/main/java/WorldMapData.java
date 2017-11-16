import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      longValue = -6593980553710502813L
   )
   static long field420;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -104666501
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("s")
   String field431;
   @ObfuscatedName("r")
   String field419;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -6914955
   )
   int field430;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 599351859
   )
   int field421;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   Coordinates field422;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2039710533
   )
   int field423;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 231792961
   )
   int field424;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 772439359
   )
   int field417;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 96704393
   )
   int field426;
   @ObfuscatedName("d")
   boolean field427;
   @ObfuscatedName("o")
   LinkedList field428;

   public WorldMapData() {
      this.fileId = -1;
      this.field430 = -1;
      this.field421 = -1;
      this.field422 = null;
      this.field423 = Integer.MAX_VALUE;
      this.field424 = 0;
      this.field417 = Integer.MAX_VALUE;
      this.field426 = 0;
      this.field427 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "1585886792"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field431 = var1.readString();
      this.field419 = var1.readString();
      this.field422 = new Coordinates(var1.readInt());
      this.field430 = var1.readInt();
      var1.readUnsignedByte();
      this.field427 = var1.readUnsignedByte() == 1;
      this.field421 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field428 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field428.add(this.method265(var1));
      }

      this.method301();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)Lap;",
      garbageValue = "1271611253"
   )
   WorldMapSectionBase method265(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field362, class27.field365, class27.field371, class27.field364};
      class27 var4 = (class27)class153.forOrdinal(var3, var2);
      Object var5 = null;
      switch(var4.field366) {
      case 0:
         var5 = new WorldMapType1();
         break;
      case 1:
         var5 = new WorldMapType3();
         break;
      case 2:
         var5 = new WorldMapType2();
         break;
      case 3:
         var5 = new class48();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod665(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-567329294"
   )
   public boolean method274(int var1, int var2, int var3) {
      Iterator var4 = this.field428.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod667(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "736355561"
   )
   public boolean method252(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field423 && var3 <= this.field424) {
         if(var4 >= this.field417 && var4 <= this.field426) {
            Iterator var5 = this.field428.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod668(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-2071233926"
   )
   public int[] method253(int var1, int var2, int var3) {
      Iterator var4 = this.field428.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod667(var1, var2, var3));

      return var5.vmethod682(var1, var2, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)Lhk;",
      garbageValue = "0"
   )
   public Coordinates method254(int var1, int var2) {
      Iterator var3 = this.field428.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod668(var1, var2));

      return var4.vmethod669(var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-32"
   )
   void method301() {
      Iterator var1 = this.field428.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod670(this);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1223822836"
   )
   public int method256() {
      return this.fileId;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1793985218"
   )
   public boolean method257() {
      return this.field427;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1028418895"
   )
   public String method258() {
      return this.field431;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1095076503"
   )
   public String method259() {
      return this.field419;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-701479048"
   )
   int method251() {
      return this.field430;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1568987829"
   )
   public int method263() {
      return this.field421;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2145985476"
   )
   public int method255() {
      return this.field423;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1899628719"
   )
   public int method312() {
      return this.field424;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-81601518"
   )
   public int method264() {
      return this.field417;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "70"
   )
   public int method310() {
      return this.field426;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-183276832"
   )
   public int method277() {
      return this.field422.worldX;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1563069350"
   )
   public int method267() {
      return this.field422.plane;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-225384131"
   )
   public int method268() {
      return this.field422.worldY;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lhk;",
      garbageValue = "2140836219"
   )
   public Coordinates method269() {
      return new Coordinates(this.field422);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;I)V",
      garbageValue = "-794775818"
   )
   public static void method321(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   public static void method319() {
      class210.field2587.method3771();
      class210.field2585 = 1;
      class70.field802 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-1053128829"
   )
   static int method250(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class82.intStack[--class82.intStackSize];
         var3 = class64.method1017(var4);
      } else {
         var3 = var2?class234.field3210:class82.field1253;
      }

      if(var0 == 1100) {
         class82.intStackSize -= 2;
         var3.scrollX = class82.intStack[class82.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class82.intStack[class82.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class82.intStack[--class82.intStackSize];
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class82.intStack[--class82.intStackSize] == 1;
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class82.intStack[--class82.intStackSize];
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class82.intStack[--class82.intStackSize];
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class82.intStack[--class82.intStackSize];
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class82.intStack[--class82.intStackSize];
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class82.intStack[--class82.intStackSize] == 1;
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class82.intStack[--class82.intStackSize];
         ScriptEvent.method1038(var3);
         return 1;
      } else if(var0 == 1109) {
         class82.intStackSize -= 6;
         var3.field2762 = class82.intStack[class82.intStackSize];
         var3.field2763 = class82.intStack[class82.intStackSize + 1];
         var3.rotationX = class82.intStack[class82.intStackSize + 2];
         var3.rotationZ = class82.intStack[class82.intStackSize + 3];
         var3.rotationY = class82.intStack[class82.intStackSize + 4];
         var3.modelZoom = class82.intStack[class82.intStackSize + 5];
         ScriptEvent.method1038(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class82.intStack[--class82.intStackSize];
            if(var9 != var3.field2760) {
               var3.field2760 = var9;
               var3.field2835 = 0;
               var3.field2723 = 0;
               ScriptEvent.method1038(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2814 = class82.intStack[--class82.intStackSize] == 1;
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class82.scriptStringStack[--class259.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               ScriptEvent.method1038(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class82.intStack[--class82.intStackSize];
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1114) {
            class82.intStackSize -= 3;
            var3.field2776 = class82.intStack[class82.intStackSize];
            var3.field2777 = class82.intStack[class82.intStackSize + 1];
            var3.field2706 = class82.intStack[class82.intStackSize + 2];
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class82.intStack[--class82.intStackSize] == 1;
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class82.intStack[--class82.intStackSize];
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class82.intStack[--class82.intStackSize];
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class82.intStack[--class82.intStackSize] == 1;
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class82.intStack[--class82.intStackSize] == 1;
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1120) {
            class82.intStackSize -= 2;
            var3.scrollWidth = class82.intStack[class82.intStackSize];
            var3.scrollHeight = class82.intStack[class82.intStackSize + 1];
            ScriptEvent.method1038(var3);
            if(var4 != -1 && var3.type == 0) {
               class90.method1686(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class233.method4090(var3.id, var3.index);
            Client.field878 = var3;
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2749 = class82.intStack[--class82.intStackSize];
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2834 = class82.intStack[--class82.intStackSize];
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2745 = class82.intStack[--class82.intStackSize];
            ScriptEvent.method1038(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class82.intStack[--class82.intStackSize];
            class292[] var6 = new class292[]{class292.field3821, class292.field3820, class292.field3818, class292.field3822, class292.field3819};
            class292 var7 = (class292)class153.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2743 = var7;
               ScriptEvent.method1038(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class82.intStack[--class82.intStackSize] == 1;
            var3.field2747 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static void method322(int var0) {
      if(var0 == -3) {
         BaseVarType.method14("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         BaseVarType.method14("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         BaseVarType.method14("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class91.loginIndex = 3;
      } else if(var0 == 4) {
         BaseVarType.method14("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         BaseVarType.method14("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         BaseVarType.method14("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         BaseVarType.method14("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         BaseVarType.method14("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         BaseVarType.method14("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         BaseVarType.method14("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         BaseVarType.method14("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         BaseVarType.method14("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         BaseVarType.method14("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         BaseVarType.method14("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         BaseVarType.method14("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         BaseVarType.method14("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         BaseVarType.method14("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         BaseVarType.method14("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         BaseVarType.method14("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         BaseVarType.method14("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         BaseVarType.method14("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         BaseVarType.method14("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         BaseVarType.method14("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         BaseVarType.method14("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         BaseVarType.method14("", "Service unavailable.", "");
      } else if(var0 == 31) {
         BaseVarType.method14("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         BaseVarType.method14("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         BaseVarType.method14("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         BaseVarType.method14("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         BaseVarType.method14("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            BaseVarType.method14("Enter the 6-digit code generated by your", "authenticator app.", "");
            class2.setGameState(11);
            return;
         }

         if(var0 == 57) {
            BaseVarType.method14("The code you entered was incorrect.", "Please try again.", "");
            class2.setGameState(11);
            return;
         }

         BaseVarType.method14("Unexpected server response", "Please try using a different world.", "");
      }

      class2.setGameState(10);
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "758634566"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class33.method323(var0, var1, var2, var3, var4, var5, false);
   }
}

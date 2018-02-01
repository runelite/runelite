import java.net.URL;
import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class89 {
   @ObfuscatedName("p")
   static boolean field1320;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1379930559
   )
   static int field1301;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1302;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1303;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lbi;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static SpritePixels field1316;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1305;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1309;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2036144577
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -257245819
   )
   static int field1307;
   @ObfuscatedName("e")
   static int[] field1340;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -43934689
   )
   static int field1311;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 690129329
   )
   static int field1312;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1822464819
   )
   static int field1313;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1832712961
   )
   static int field1314;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -779239747
   )
   static int field1334;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1097111843
   )
   static int field1310;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1347217639
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("am")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1495256447
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("an")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ag")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("av")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("aw")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ad")
   @Export("username")
   static String username;
   @ObfuscatedName("ab")
   @Export("password")
   static String password;
   @ObfuscatedName("aq")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("al")
   static boolean field1327;
   @ObfuscatedName("bw")
   static boolean field1328;
   @ObfuscatedName("bq")
   static boolean field1329;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 115268699
   )
   static int field1300;
   @ObfuscatedName("bm")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1279063787
   )
   static int field1335;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      longValue = -8546034870853608553L
   )
   static long field1336;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      longValue = 2442924046103939605L
   )
   static long field1337;

   static {
      field1301 = 0;
      loginWindowX = field1301 + 202;
      field1340 = new int[256];
      field1311 = 0;
      field1312 = 0;
      field1313 = 0;
      field1314 = 0;
      field1334 = 0;
      field1310 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      Login_response0 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      Login_isUsernameRemembered = false;
      field1327 = false;
      field1328 = false;
      field1329 = true;
      field1300 = 0;
      worldSelectShown = false;
      field1335 = -1;
      new DecimalFormat("##0.00");
      new class150();
      field1336 = -1L;
      field1337 = -1L;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;S)V",
      garbageValue = "25615"
   )
   public static void method1900(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-79"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class238.listFetcher == null) {
            class238.listFetcher = class63.urlRequester.request(new URL(Client.field828));
         } else if(class238.listFetcher.isDone()) {
            byte[] var0 = class238.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            ScriptEvent.method1081(worldList, 0, worldList.length - 1, World.field1173, World.field1171);
            class238.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class238.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-318123956"
   )
   static void method1904() {
      class25.field352 = null;
      class61.field687 = null;
      class61.field688 = null;
      IndexFile.field2159 = null;
      class61.field690 = null;
      class29.field392 = null;
      Item.field1371 = null;
      class31.field413 = null;
      BaseVarType.field24 = null;
      class61.field685 = null;
      ItemLayer.field1669 = null;
      Ignore.field3688 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgd;I)V",
      garbageValue = "-856316041"
   )
   static final void method1867(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class92.playerIndexesCount; ++var2) {
         var3 = class92.playerIndices[var2];
         if((class92.field1375[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = class3.method10(var0);
                  class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
               } else {
                  BaseVarType.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class92.playerIndexesCount; ++var2) {
            var3 = class92.playerIndices[var2];
            if((class92.field1375[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = class3.method10(var0);
                     class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
                  } else {
                     BaseVarType.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class92.field1373; ++var2) {
               var3 = class92.field1384[var2];
               if((class92.field1375[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = class3.method10(var0);
                        class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
                     } else if(class237.decodeRegionHash(var0, var3)) {
                        class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class92.field1373; ++var2) {
                  var3 = class92.field1384[var2];
                  if((class92.field1375[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = class3.method10(var0);
                           class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
                        } else if(class237.decodeRegionHash(var0, var3)) {
                           class92.field1375[var3] = (byte)(class92.field1375[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class92.playerIndexesCount = 0;
                  class92.field1373 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class92.field1375[var2] = (byte)(class92.field1375[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class92.playerIndices[++class92.playerIndexesCount - 1] = var2;
                     } else {
                        class92.field1384[++class92.field1373 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "672296109"
   )
   public static void method1880() {
      try {
         if(class214.field2596 == 1) {
            int var0 = class214.field2595.method3957();
            if(var0 > 0 && class214.field2595.method3963()) {
               var0 -= class85.field1268;
               if(var0 < 0) {
                  var0 = 0;
               }

               class214.field2595.method3956(var0);
               return;
            }

            class214.field2595.method3962();
            class214.field2595.method4009();
            if(Item.field1369 != null) {
               class214.field2596 = 2;
            } else {
               class214.field2596 = 0;
            }

            class214.field2599 = null;
            ContextMenuRow.field1281 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class214.field2595.method3962();
         class214.field2596 = 0;
         class214.field2599 = null;
         ContextMenuRow.field1281 = null;
         Item.field1369 = null;
      }

   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Lho;Ljj;IIZB)V",
      garbageValue = "-109"
   )
   static final void method1903(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         Parameters.method5333(var7, class1.getColTags(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lho;IIB)V",
      garbageValue = "90"
   )
   static final void method1874(Widget var0, int var1, int var2) {
      if(Client.field980 == null && !Client.isMenuOpen) {
         if(var0 != null && class21.method169(var0) != null) {
            Client.field980 = var0;
            Client.field981 = class21.method169(var0);
            Client.field982 = var1;
            Client.field983 = var2;
            VarPlayerType.field3350 = 0;
            Client.field991 = false;
            int var3 = class34.method365();
            if(var3 != -1) {
               Widget.method4303(var3);
            }

         }
      }
   }
}

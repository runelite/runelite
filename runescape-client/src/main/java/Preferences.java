import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("gq")
   static SpritePixels[] field1282;
   @ObfuscatedName("u")
   boolean field1284;
   @ObfuscatedName("q")
   boolean field1285;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1467157769
   )
   int field1286;
   @ObfuscatedName("v")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -775508407
   )
   static int field1288;
   @ObfuscatedName("z")
   static int[] field1289;

   Preferences(Buffer var1) {
      this.field1286 = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1288) {
            if(var1.readUnsignedByte() == 1) {
               this.field1284 = true;
            }

            if(var2 > 1) {
               this.field1285 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field1286 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method1605(true);
         }
      } else {
         this.method1605(true);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-102"
   )
   static void method1591() {
      for(class82 var0 = (class82)class82.field1299.method3660(); var0 != null; var0 = (class82)class82.field1299.method3661()) {
         if(var0.field1307 != null) {
            var0.method1611();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
      garbageValue = "9"
   )
   static File method1592(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class226.field3126 = new File(class60.field735, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      File var23;
      if(class226.field3126.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class226.field3126, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.method2386()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method2387(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.method3208();
               if(var10 == 1) {
                  var5 = var8.method3208();
               }
            } else {
               var4 = var8.method3209();
               if(var10 == 1) {
                  var5 = var8.method3209();
               }
            }

            var7.method2385();
         } catch (IOException var21) {
            var21.printStackTrace();
         }

         if(var4 != null) {
            var23 = new File(var4);
            if(!var23.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var23 = new File(var4, "test.dat");
            if(!MessageNode.method1131(var23, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label140:
         for(int var15 = 0; var15 < class155.field2227.length; ++var15) {
            for(int var16 = 0; var16 < class60.field736.length; ++var16) {
               File var17 = new File(class60.field736[var16] + class155.field2227[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && MessageNode.method1131(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label140;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class60.field735 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var22;
      if(var5 != null) {
         var22 = new File(var5);
         var23 = new File(var4);

         try {
            File[] var24 = var22.listFiles();
            File[] var18 = var24;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var23, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var22 = new File(var4);
         var8 = null;

         try {
            FileOnDisk var25 = new FileOnDisk(class226.field3126, "rw", 10000L);
            Buffer var26 = new Buffer(500);
            var26.putByte(3);
            var26.putByte(var8 != null?1:0);
            var26.method3203(var22.getPath());
            if(var8 != null) {
               var26.method3203("");
            }

            var25.method2384(var26.payload, 0, var26.offset);
            var25.method2385();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }

   static {
      field1288 = 4;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-943639666"
   )
   static final boolean method1593(int var0, int var1) {
      ObjectComposition var2 = class43.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4589(var1);
   }

   Preferences() {
      this.field1286 = 1;
      this.preferences = new LinkedHashMap();
      this.method1605(true);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "-86"
   )
   Buffer method1602() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1288);
      var1.putByte(this.field1284?1:0);
      var1.putByte(this.field1285?1:0);
      var1.putByte(this.field1286);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "274788093"
   )
   void method1605(boolean var1) {
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "93001409"
   )
   static final void method1608(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field1012 == 1) && Client.friendCount < 400) {
            String var1 = class27.method214(var0, WorldMapType1.field423);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class27.method214(var3.name, WorldMapType1.field423);
                  if(var4 != null && var4.equals(var1)) {
                     GameObject.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class27.method214(var3.previousName, WorldMapType1.field423);
                     if(var5 != null && var5.equals(var1)) {
                        GameObject.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class27.method214(var6.name, WorldMapType1.field423);
                  if(var4 != null && var4.equals(var1)) {
                     GameObject.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = class27.method214(var6.previousName, WorldMapType1.field423);
                     if(var5 != null && var5.equals(var1)) {
                        GameObject.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class27.method214(XGrandExchangeOffer.localPlayer.name, WorldMapType1.field423).equals(var1)) {
                  GameObject.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(105);
                  Client.secretPacketBuffer1.putByte(class46.method711(var0));
                  Client.secretPacketBuffer1.method3191(var0);
               }
            }
         } else {
            GameObject.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lclass239;",
      garbageValue = "2028409270"
   )
   static class239[] method1609() {
      return new class239[]{class239.field3264, class239.field3261, class239.field3262};
   }
}

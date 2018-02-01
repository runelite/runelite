import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class23 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field331;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1788076937"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class289.cp1252AsciiExtension[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "313991961"
   )
   static void method178() {
      class89.username = class89.username.trim();
      if(class89.username.length() == 0) {
         PacketNode.method3314("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = Preferences.method1658();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = ItemLayer.method2562(var1, class89.username);
         }

         switch(var0) {
         case 2:
            PacketNode.method3314("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class89.loginIndex = 6;
            break;
         case 3:
            PacketNode.method3314("", "Error connecting to server.", "");
            break;
         case 4:
            PacketNode.method3314("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            PacketNode.method3314("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            PacketNode.method3314("", "Error connecting to server.", "");
            break;
         case 7:
            PacketNode.method3314("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "6"
   )
   static int method180(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(ServerPacket.friendManager.field1195 == 0) {
            class80.intStack[++class80.intStackSize - 1] = -2;
         } else if(ServerPacket.friendManager.field1195 == 1) {
            class80.intStack[++class80.intStackSize - 1] = -1;
         } else {
            class80.intStack[++class80.intStackSize - 1] = ServerPacket.friendManager.field1191.getCount();
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class80.intStack[--class80.intStackSize];
            if(ServerPacket.friendManager.method1664() && var3 >= 0 && var3 < ServerPacket.friendManager.field1191.getCount()) {
               Friend var9 = (Friend)ServerPacket.friendManager.field1191.get(var3);
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var9.method5011();
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var9.method5002();
            } else {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class80.intStack[--class80.intStackSize];
            if(ServerPacket.friendManager.method1664() && var3 >= 0 && var3 < ServerPacket.friendManager.field1191.getCount()) {
               class80.intStack[++class80.intStackSize - 1] = ((Friend)ServerPacket.friendManager.field1191.get(var3)).world;
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class80.intStack[--class80.intStackSize];
            if(ServerPacket.friendManager.method1664() && var3 >= 0 && var3 < ServerPacket.friendManager.field1191.getCount()) {
               class80.intStack[++class80.intStackSize - 1] = ((Friend)ServerPacket.friendManager.field1191.get(var3)).field3707;
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var6;
            if(var0 == 3604) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               int var7 = class80.intStack[--class80.intStackSize];
               PacketNode var5 = class35.method501(ClientPacket.field2358, Client.field867.field1439);
               var5.packetBuffer.putByte(ContextMenuRow.getLength(var6) + 1);
               var5.packetBuffer.method3430(var7);
               var5.packetBuffer.putString(var6);
               Client.field867.method2021(var5);
               return 1;
            } else if(var0 == 3605) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               ServerPacket.friendManager.method1707(var6);
               return 1;
            } else if(var0 == 3606) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               ServerPacket.friendManager.method1675(var6);
               return 1;
            } else if(var0 == 3607) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               ServerPacket.friendManager.method1673(var6);
               return 1;
            } else if(var0 == 3608) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               ServerPacket.friendManager.method1713(var6);
               return 1;
            } else if(var0 == 3609) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               var6 = class33.method361(var6);
               class80.intStack[++class80.intStackSize - 1] = ServerPacket.friendManager.isFriended(new Name(var6, class34.loginType), false)?1:0;
               return 1;
            } else if(var0 == 3611) {
               if(class234.clanMemberManager != null) {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = class234.clanMemberManager.field3713;
               } else {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3612) {
               if(class234.clanMemberManager != null) {
                  class80.intStack[++class80.intStackSize - 1] = class234.clanMemberManager.getCount();
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3613) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class234.clanMemberManager != null && var3 < class234.clanMemberManager.getCount()) {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = class234.clanMemberManager.get(var3).method5001().getName();
               } else {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3614) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class234.clanMemberManager != null && var3 < class234.clanMemberManager.getCount()) {
                  class80.intStack[++class80.intStackSize - 1] = ((ClanMember)class234.clanMemberManager.get(var3)).world;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3615) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class234.clanMemberManager != null && var3 < class234.clanMemberManager.getCount()) {
                  class80.intStack[++class80.intStackSize - 1] = ((ClanMember)class234.clanMemberManager.get(var3)).rank;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3616) {
               class80.intStack[++class80.intStackSize - 1] = class234.clanMemberManager != null?class234.clanMemberManager.field3711:0;
               return 1;
            } else if(var0 == 3617) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               Item.method1921(var6);
               return 1;
            } else if(var0 == 3618) {
               class80.intStack[++class80.intStackSize - 1] = class234.clanMemberManager != null?class234.clanMemberManager.field3714:0;
               return 1;
            } else if(var0 == 3619) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               if(!var6.equals("")) {
                  PacketNode var8 = class35.method501(ClientPacket.field2370, Client.field867.field1439);
                  var8.packetBuffer.putByte(ContextMenuRow.getLength(var6));
                  var8.packetBuffer.putString(var6);
                  Client.field867.method2021(var8);
               }

               return 1;
            } else if(var0 == 3620) {
               PacketNode var10 = class35.method501(ClientPacket.field2370, Client.field867.field1439);
               var10.packetBuffer.putByte(0);
               Client.field867.method2021(var10);
               return 1;
            } else if(var0 == 3621) {
               if(!ServerPacket.friendManager.method1664()) {
                  class80.intStack[++class80.intStackSize - 1] = -1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = ServerPacket.friendManager.field1196.getCount();
               }

               return 1;
            } else if(var0 == 3622) {
               var3 = class80.intStack[--class80.intStackSize];
               if(ServerPacket.friendManager.method1664() && var3 >= 0 && var3 < ServerPacket.friendManager.field1196.getCount()) {
                  Ignore var4 = (Ignore)ServerPacket.friendManager.field1196.get(var3);
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var4.method5011();
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var4.method5002();
               } else {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3623) {
               var6 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               var6 = class33.method361(var6);
               class80.intStack[++class80.intStackSize - 1] = ServerPacket.friendManager.method1670(new Name(var6, class34.loginType))?1:0;
               return 1;
            } else if(var0 == 3624) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class234.clanMemberManager != null && var3 < class234.clanMemberManager.getCount() && class234.clanMemberManager.get(var3).method5001().equals(class36.localPlayer.name)) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3625) {
               if(class234.clanMemberManager != null && class234.clanMemberManager.field3708 != null) {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = class234.clanMemberManager.field3708;
               } else {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3626) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class234.clanMemberManager != null && var3 < class234.clanMemberManager.getCount() && ((ClanMember)class234.clanMemberManager.get(var3)).method4996()) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 != 3627) {
               return 2;
            } else {
               var3 = class80.intStack[--class80.intStackSize];
               if(class234.clanMemberManager != null && var3 < class234.clanMemberManager.getCount() && ((ClanMember)class234.clanMemberManager.get(var3)).method4990()) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }
}

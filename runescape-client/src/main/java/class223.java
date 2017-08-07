import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class223 {
   @ObfuscatedName("n")
   public static final boolean[] field2812;
   @ObfuscatedName("g")
   public static int[] field2808;

   static {
      field2812 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2808 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2808[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "323258208"
   )
   static void method4075(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1281[var5] != var0) {
            var2[var4] = World.field1281[var5];
            var3[var4] = World.field1291[var5];
            ++var4;
         }
      }

      World.field1281 = var2;
      World.field1291 = var3;
      class164.method3096(class51.worldList, 0, class51.worldList.length - 1, World.field1281, World.field1291);
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   static void method4074() {
      Client.field1181 = -1L;
      Client.field937 = -1;
      class153.field2205.field857 = 0;
      class7.field226 = true;
      Client.field1057 = true;
      Client.field943 = -1L;
      CombatInfoListHolder.method1705();
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = -1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.field968 = 0;
      Client.field931 = 0;
      Client.field1040 = 0;
      Client.field1103 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      MouseInput.mouseIdleTicks = 0;
      class99.chatLineMap.clear();
      class99.field1516.clear();
      class99.field1520.method3672();
      class99.field1515 = 0;
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.field1144 = 0;
      Client.mapAngle = 0;
      Client.field1138 = 0;
      Client.field949 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.field940 = class92.field1410;
      Client.field1089 = class92.field1410;
      Client.field952 = 0;
      Projectile.method1793();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field1031 = -1;
      Client.projectiles.clear();
      Client.graphicsObjectDeque.clear();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new Deque();
      Client.field1170 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < VarPlayerType.field3270; ++var0) {
         VarPlayerType var3 = class36.method497(var0);
         if(var3 != null) {
            class212.settings[var0] = 0;
            class212.widgetSettings[var0] = 0;
         }
      }

      class47.chatMessages.reset();
      Client.field954 = -1;
      if(Client.widgetRoot != -1) {
         class99.method1881(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3549(); var4 != null; var4 = (WidgetNode)Client.componentTable.method3556()) {
         class18.method141(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field1066 = null;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1035.method3951((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      XItemContainer.itemContainers = new XHashTable(32);
      Client.field923 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1107[var0] = true;
      }

      XGrandExchangeOffer.method113();
      Client.clanChatOwner = null;
      class5.clanChatCount = 0;
      WorldMapData.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class170.field2327 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-2024678919"
   )
   static char method4076(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }
}

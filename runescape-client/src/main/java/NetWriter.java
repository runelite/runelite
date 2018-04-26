import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   @Export("rssocket")
   class169 rssocket;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -256545087
   )
   int field1459;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public ISAACCipher field1460;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 854389791
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("c")
   boolean field1461;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1507713307
   )
   int field1465;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1514783929
   )
   int field1466;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   ServerPacket field1467;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   ServerPacket field1468;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   ServerPacket field1458;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1459 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1461 = true;
      this.field1465 = 0;
      this.field1466 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1822427541"
   )
   final void method2133() {
      this.packetBufferNodes.method4060();
      this.field1459 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method2134() throws IOException {
      if(this.rssocket != null && this.field1459 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2489 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3411(this.buffer.payload, 0, this.buffer.offset);
               this.field1466 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2489);
            this.field1459 -= var1.field2489;
            var1.unlink();
            var1.packetBuffer.method3582();
            var1.method3508();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "1514812192"
   )
   public final void method2135(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2489 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1459 += var1.field2489;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "879890870"
   )
   @Export("setSocket")
   void setSocket(class169 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3404();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1830930924"
   )
   void method2138() {
      this.rssocket = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lfs;",
      garbageValue = "2007438072"
   )
   @Export("getSocket")
   class169 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static void method2150() {
      for(class80 var0 = (class80)class80.field1247.getFront(); var0 != null; var0 = (class80)class80.field1247.getNext()) {
         if(var0.field1251 != null) {
            BoundingBox2D.field238.method2167(var0.field1251);
            var0.field1251 = null;
         }

         if(var0.field1244 != null) {
            BoundingBox2D.field238.method2167(var0.field1244);
            var0.field1244 = null;
         }
      }

      class80.field1247.clear();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;Ljr;Ljr;B)V",
      garbageValue = "-14"
   )
   public static void method2161(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      Widget.widgetIndex = var0;
      Varcs.field1419 = var1;
      class18.field319 = var2;
      Widget.field2814 = var3;
      GZipDecompressor.widgets = new Widget[Widget.widgetIndex.size()][];
      class250.validInterfaces = new boolean[Widget.widgetIndex.size()];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhh;IIS)I",
      garbageValue = "10598"
   )
   static int method2162(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lju;",
      garbageValue = "0"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.updateNote(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method5132(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.placeholderTemplateId != -1) {
            var1.method5146(getItemDefinition(var1.placeholderTemplateId), getItemDefinition(var1.placeholderId));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.shiftClickIndex = -1;
            var1.team = 0;
            if(var1.params != null) {
               boolean var3 = false;

               for(Node var4 = var1.params.getHead(); var4 != null; var4 = var1.params.getTail()) {
                  class278 var5 = class253.method4619((int)var4.hash);
                  if(var5.field3551) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.params = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "1022478859"
   )
   static void method2154(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class57.field655.startsWith("win") && !var3) {
            class281.method5078(var0, 0);
            return;
         }

         if(class57.field655.startsWith("mac")) {
            class7.method28(var0, 1, var2);
            return;
         }

         class281.method5078(var0, 2);
      } else {
         class281.method5078(var0, 3);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "65535"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method2159() {
      try {
         if(class229.field2694 == 1) {
            int var0 = class38.field507.method4236();
            if(var0 > 0 && class38.field507.method4242()) {
               var0 -= class20.field335;
               if(var0 < 0) {
                  var0 = 0;
               }

               class38.field507.method4324(var0);
               return;
            }

            class38.field507.method4241();
            class38.field507.method4239();
            if(class132.field1905 != null) {
               class229.field2694 = 2;
            } else {
               class229.field2694 = 0;
            }

            class229.field2698 = null;
            class237.field2788 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class38.field507.method4241();
         class229.field2694 = 0;
         class229.field2698 = null;
         class237.field2788 = null;
         class132.field1905 = null;
      }

   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Liz;I)Z",
      garbageValue = "-1654967752"
   )
   static final boolean method2140(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field899 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1113.method4489(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1113.method4490(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1113.method4487(false);
         }

         if(var1 == 325) {
            Client.field1113.method4487(true);
         }

         if(var1 == 326) {
            PacketNode var4 = AbstractSoundSystem.method2350(ClientPacket.field2445, Client.field911.field1460);
            Client.field1113.method4492(var4.packetBuffer);
            Client.field911.method2135(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}

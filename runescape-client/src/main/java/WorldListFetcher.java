import java.awt.Image;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("WorldListFetcher")
public class WorldListFetcher {
   @ObfuscatedName("au")
   static Image field1188;
   @ObfuscatedName("y")
   @Export("sizeBytes")
   byte[] sizeBytes;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 604348701
   )
   @Export("state")
   int state;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 5564550937036774437L
   )
   @Export("timeout")
   long timeout;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 850052333
   )
   @Export("sizeOffset")
   int sizeOffset;
   @ObfuscatedName("x")
   @Export("dis")
   DataInputStream dis;
   @ObfuscatedName("f")
   @Export("payloadBytes")
   byte[] payloadBytes;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 999155445
   )
   @Export("payloadOffset")
   int payloadOffset;

   @ObfuscatedSignature(
      signature = "(Leg;Ljava/net/URL;)V"
   )
   WorldListFetcher(Signlink var1, URL var2) {
      this.sizeBytes = new byte[4];
      this.task = var1.createURL(var2);
      this.state = 0;
      this.timeout = BuildType.currentTimeMs() + 30000L;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1426885369"
   )
   @Export("fetch")
   byte[] fetch() throws IOException {
      if(BuildType.currentTimeMs() > this.timeout) {
         throw new IOException();
      } else {
         if(this.state == 0) {
            if(this.task.status == 2) {
               throw new IOException();
            }

            if(this.task.status == 1) {
               this.dis = (DataInputStream)this.task.value;
               this.state = 1;
            }
         }

         if(this.state == 1) {
            this.sizeOffset += this.dis.read(this.sizeBytes, this.sizeOffset, this.sizeBytes.length - this.sizeOffset);
            if(this.sizeOffset == 4) {
               int var1 = (new Buffer(this.sizeBytes)).readInt();
               this.payloadBytes = new byte[var1];
               this.state = 2;
            }
         }

         if(this.state == 2) {
            this.payloadOffset += this.dis.read(this.payloadBytes, this.payloadOffset, this.payloadBytes.length - this.payloadOffset);
            if(this.payloadBytes.length == this.payloadOffset) {
               return this.payloadBytes;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "1203075668"
   )
   public static byte method1528(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "([Lhn;Lhn;ZI)V",
      garbageValue = "-2059162690"
   )
   static void method1530(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class46.method686(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class46.method686(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class7.loadWidget(var6)) {
            class46.method686(class170.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-791884621"
   )
   static final void method1532(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class152.method2949(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1163 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}

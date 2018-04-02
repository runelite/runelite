import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -766276273
   )
   static int field813;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1758157563
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2090519135
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1642637665
   )
   @Export("type")
   int type;
   @ObfuscatedName("j")
   @Export("name")
   String name;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   Name field803;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field808;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field809;
   @ObfuscatedName("p")
   @Export("sender")
   String sender;
   @ObfuscatedName("w")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field808 = class303.field3842;
      this.field809 = class303.field3842;
      this.id = SceneTilePaint.method2872();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1115();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "124"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = SceneTilePaint.method2872();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1115();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1953083949"
   )
   void method1131() {
      this.field808 = class303.field3842;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-859249780"
   )
   final boolean method1110() {
      if(this.field808 == class303.field3842) {
         this.method1111();
      }

      return this.field808 == class303.field3841;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1432437519"
   )
   void method1111() {
      this.field808 = RunException.friendManager.field1250.isMember(this.field803)?class303.field3841:class303.field3843;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1469431463"
   )
   void method1107() {
      this.field809 = class303.field3842;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "60"
   )
   final boolean method1113() {
      if(this.field809 == class303.field3842) {
         this.method1114();
      }

      return this.field809 == class303.field3841;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-359402641"
   )
   void method1114() {
      this.field809 = RunException.friendManager.field1249.isMember(this.field803)?class303.field3841:class303.field3843;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-839214170"
   )
   final void method1115() {
      if(this.name != null) {
         this.field803 = new Name(MapIconReference.method747(this.name), Client.loginType);
      } else {
         this.field803 = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-728270429"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
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
}

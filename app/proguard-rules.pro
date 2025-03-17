# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#Hack, currently crashes without this, need to figure out the
# proper class to exclude.
-dontobfuscate
-dontshrink

-dontwarn ch.qos.logback.classic.Level
-dontwarn ch.qos.logback.classic.spi.ILoggingEvent
-dontwarn ch.qos.logback.classic.spi.IThrowableProxy
-dontwarn ch.qos.logback.classic.spi.ThrowableProxy
-dontwarn ch.qos.logback.core.UnsynchronizedAppenderBase
-dontwarn com.aayushatharva.brotli4j.Brotli4jLoader
-dontwarn com.aayushatharva.brotli4j.decoder.DecoderJNI$Status
-dontwarn com.aayushatharva.brotli4j.decoder.DecoderJNI$Wrapper
-dontwarn com.aayushatharva.brotli4j.encoder.BrotliEncoderChannel
-dontwarn com.aayushatharva.brotli4j.encoder.Encoder$Mode
-dontwarn com.aayushatharva.brotli4j.encoder.Encoder$Parameters
-dontwarn com.aayushatharva.brotli4j.encoder.Encoder
-dontwarn com.codahale.metrics.health.HealthCheck$Result
-dontwarn com.codahale.metrics.health.HealthCheck
-dontwarn com.codahale.metrics.health.HealthCheckRegistry
-dontwarn com.github.luben.zstd.Zstd
-dontwarn com.google.protobuf.ExtensionRegistry
-dontwarn com.google.protobuf.ExtensionRegistryLite
-dontwarn com.google.protobuf.MessageLite$Builder
-dontwarn com.google.protobuf.MessageLite
-dontwarn com.google.protobuf.MessageLiteOrBuilder
-dontwarn com.google.protobuf.Parser
-dontwarn com.google.protobuf.nano.CodedOutputByteBufferNano
-dontwarn com.google.protobuf.nano.MessageNano
-dontwarn com.jcraft.jzlib.Deflater
-dontwarn com.jcraft.jzlib.Inflater
-dontwarn com.jcraft.jzlib.JZlib$WrapperType
-dontwarn com.jcraft.jzlib.JZlib
-dontwarn com.ning.compress.BufferRecycler
-dontwarn com.ning.compress.lzf.ChunkDecoder
-dontwarn com.ning.compress.lzf.ChunkEncoder
-dontwarn com.ning.compress.lzf.LZFChunk
-dontwarn com.ning.compress.lzf.LZFEncoder
-dontwarn com.ning.compress.lzf.util.ChunkDecoderFactory
-dontwarn com.ning.compress.lzf.util.ChunkEncoderFactory
-dontwarn com.oracle.svm.core.annotate.Alias
-dontwarn com.oracle.svm.core.annotate.InjectAccessors
-dontwarn com.oracle.svm.core.annotate.RecomputeFieldValue$Kind
-dontwarn com.oracle.svm.core.annotate.RecomputeFieldValue
-dontwarn com.oracle.svm.core.annotate.TargetClass
-dontwarn io.netty.internal.tcnative.AsyncSSLPrivateKeyMethod
-dontwarn io.netty.internal.tcnative.AsyncTask
-dontwarn io.netty.internal.tcnative.Buffer
-dontwarn io.netty.internal.tcnative.CertificateCallback
-dontwarn io.netty.internal.tcnative.CertificateCompressionAlgo
-dontwarn io.netty.internal.tcnative.CertificateVerifier
-dontwarn io.netty.internal.tcnative.Library
-dontwarn io.netty.internal.tcnative.ResultCallback
-dontwarn io.netty.internal.tcnative.SSL
-dontwarn io.netty.internal.tcnative.SSLContext
-dontwarn io.netty.internal.tcnative.SSLPrivateKeyMethod
-dontwarn io.netty.internal.tcnative.SSLSession
-dontwarn io.netty.internal.tcnative.SSLSessionCache
-dontwarn io.netty.internal.tcnative.SessionTicketKey
-dontwarn io.netty.internal.tcnative.SniHostNameMatcher
-dontwarn io.prometheus.client.Collector$MetricFamilySamples$Sample
-dontwarn io.prometheus.client.Collector$MetricFamilySamples
-dontwarn io.prometheus.client.Collector$Type
-dontwarn io.prometheus.client.Collector
-dontwarn io.prometheus.client.Counter$Builder
-dontwarn io.prometheus.client.Counter$Child
-dontwarn io.prometheus.client.Counter
-dontwarn io.prometheus.client.SimpleCollector$Builder
-dontwarn io.prometheus.client.SimpleCollector
-dontwarn io.prometheus.client.Summary$Builder
-dontwarn io.prometheus.client.Summary$Child
-dontwarn io.prometheus.client.Summary
-dontwarn jakarta.servlet.ServletContainerInitializer
-dontwarn jakarta.servlet.ServletContext
-dontwarn jakarta.servlet.ServletException
-dontwarn jakarta.servlet.ServletRequest
-dontwarn jakarta.servlet.ServletRequestEvent
-dontwarn jakarta.servlet.ServletRequestListener
-dontwarn jakarta.servlet.http.HttpServletRequest
-dontwarn java.awt.BorderLayout
-dontwarn java.awt.Component
-dontwarn java.awt.Container
-dontwarn java.awt.Dimension
-dontwarn java.awt.GridBagConstraints
-dontwarn java.awt.GridBagLayout
-dontwarn java.awt.LayoutManager
-dontwarn java.awt.event.ActionEvent
-dontwarn java.awt.event.ActionListener
-dontwarn java.awt.event.WindowAdapter
-dontwarn java.awt.event.WindowEvent
-dontwarn java.awt.event.WindowListener
-dontwarn java.beans.BeanInfo
-dontwarn java.beans.ConstructorProperties
-dontwarn java.beans.IntrospectionException
-dontwarn java.beans.Introspector
-dontwarn java.beans.PropertyDescriptor
-dontwarn java.beans.Transient
-dontwarn java.lang.management.ClassLoadingMXBean
-dontwarn java.lang.management.GarbageCollectorMXBean
-dontwarn java.lang.management.LockInfo
-dontwarn java.lang.management.ManagementFactory
-dontwarn java.lang.management.MemoryMXBean
-dontwarn java.lang.management.MemoryPoolMXBean
-dontwarn java.lang.management.MemoryUsage
-dontwarn java.lang.management.MonitorInfo
-dontwarn java.lang.management.OperatingSystemMXBean
-dontwarn java.lang.management.RuntimeMXBean
-dontwarn java.lang.management.ThreadInfo
-dontwarn java.lang.management.ThreadMXBean
-dontwarn java.sql.SQLType
-dontwarn javassist.ClassMap
-dontwarn javassist.ClassPath
-dontwarn javassist.ClassPool
-dontwarn javassist.CtClass
-dontwarn javassist.CtMethod
-dontwarn javassist.CtNewMethod
-dontwarn javassist.LoaderClassPath
-dontwarn javassist.NotFoundException
-dontwarn javassist.bytecode.ClassFile
-dontwarn javax.jms.Destination
-dontwarn javax.jms.JMSException
-dontwarn javax.jms.Message
-dontwarn javax.jms.MessageListener
-dontwarn javax.jms.ObjectMessage
-dontwarn javax.jms.Topic
-dontwarn javax.jms.TopicConnection
-dontwarn javax.jms.TopicConnectionFactory
-dontwarn javax.jms.TopicPublisher
-dontwarn javax.jms.TopicSession
-dontwarn javax.jms.TopicSubscriber
-dontwarn javax.mail.Address
-dontwarn javax.mail.Authenticator
-dontwarn javax.mail.BodyPart
-dontwarn javax.mail.Message$RecipientType
-dontwarn javax.mail.Message
-dontwarn javax.mail.MessagingException
-dontwarn javax.mail.Multipart
-dontwarn javax.mail.PasswordAuthentication
-dontwarn javax.mail.Session
-dontwarn javax.mail.Transport
-dontwarn javax.mail.internet.AddressException
-dontwarn javax.mail.internet.InternetAddress
-dontwarn javax.mail.internet.InternetHeaders
-dontwarn javax.mail.internet.MimeBodyPart
-dontwarn javax.mail.internet.MimeMessage
-dontwarn javax.mail.internet.MimeMultipart
-dontwarn javax.mail.internet.MimeUtility
-dontwarn javax.management.InstanceAlreadyExistsException
-dontwarn javax.management.InstanceNotFoundException
-dontwarn javax.management.JMException
-dontwarn javax.management.MBeanInfo
-dontwarn javax.management.MBeanRegistrationException
-dontwarn javax.management.MBeanServer
-dontwarn javax.management.MBeanServerConnection
-dontwarn javax.management.MalformedObjectNameException
-dontwarn javax.management.ObjectInstance
-dontwarn javax.management.ObjectName
-dontwarn javax.management.QueryExp
-dontwarn javax.naming.Context
-dontwarn javax.naming.InitialContext
-dontwarn javax.naming.Name
-dontwarn javax.naming.NamingException
-dontwarn javax.naming.RefAddr
-dontwarn javax.naming.Reference
-dontwarn javax.naming.spi.ObjectFactory
-dontwarn javax.servlet.ServletContainerInitializer
-dontwarn javax.servlet.ServletContext
-dontwarn javax.servlet.ServletException
-dontwarn javax.servlet.ServletRequest
-dontwarn javax.servlet.ServletRequestEvent
-dontwarn javax.servlet.ServletRequestListener
-dontwarn javax.servlet.http.HttpServletRequest
-dontwarn javax.swing.AbstractAction
-dontwarn javax.swing.BorderFactory
-dontwarn javax.swing.JButton
-dontwarn javax.swing.JComboBox
-dontwarn javax.swing.JEditorPane
-dontwarn javax.swing.JFileChooser
-dontwarn javax.swing.JFrame
-dontwarn javax.swing.JLabel
-dontwarn javax.swing.JMenu
-dontwarn javax.swing.JMenuBar
-dontwarn javax.swing.JMenuItem
-dontwarn javax.swing.JOptionPane
-dontwarn javax.swing.JPanel
-dontwarn javax.swing.JScrollPane
-dontwarn javax.swing.JSplitPane
-dontwarn javax.swing.JTable
-dontwarn javax.swing.JTextField
-dontwarn javax.swing.ListSelectionModel
-dontwarn javax.swing.border.Border
-dontwarn javax.swing.border.TitledBorder
-dontwarn javax.swing.event.DocumentEvent
-dontwarn javax.swing.event.DocumentListener
-dontwarn javax.swing.event.ListSelectionEvent
-dontwarn javax.swing.event.ListSelectionListener
-dontwarn javax.swing.table.AbstractTableModel
-dontwarn javax.swing.table.TableModel
-dontwarn javax.swing.text.Document
-dontwarn javax.xml.bind.DatatypeConverter
-dontwarn lzma.sdk.ICodeProgress
-dontwarn lzma.sdk.lzma.Encoder
-dontwarn net.jpountz.lz4.LZ4Compressor
-dontwarn net.jpountz.lz4.LZ4Exception
-dontwarn net.jpountz.lz4.LZ4Factory
-dontwarn net.jpountz.lz4.LZ4FastDecompressor
-dontwarn net.jpountz.xxhash.XXHash32
-dontwarn net.jpountz.xxhash.XXHashFactory
-dontwarn org.apache.logging.log4j.Level
-dontwarn org.apache.logging.log4j.LogManager
-dontwarn org.apache.logging.log4j.Logger
-dontwarn org.apache.logging.log4j.message.MessageFactory
-dontwarn org.apache.logging.log4j.spi.ExtendedLogger
-dontwarn org.apache.logging.log4j.spi.ExtendedLoggerWrapper
-dontwarn org.bouncycastle.asn1.pkcs.PrivateKeyInfo
-dontwarn org.bouncycastle.asn1.x500.X500Name
-dontwarn org.bouncycastle.cert.X509CertificateHolder
-dontwarn org.bouncycastle.cert.X509v3CertificateBuilder
-dontwarn org.bouncycastle.cert.jcajce.JcaX509CertificateConverter
-dontwarn org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder
-dontwarn org.bouncycastle.jce.provider.BouncyCastleProvider
-dontwarn org.bouncycastle.openssl.PEMDecryptorProvider
-dontwarn org.bouncycastle.openssl.PEMEncryptedKeyPair
-dontwarn org.bouncycastle.openssl.PEMKeyPair
-dontwarn org.bouncycastle.openssl.PEMParser
-dontwarn org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter
-dontwarn org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder
-dontwarn org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder
-dontwarn org.bouncycastle.operator.ContentSigner
-dontwarn org.bouncycastle.operator.InputDecryptorProvider
-dontwarn org.bouncycastle.operator.OperatorCreationException
-dontwarn org.bouncycastle.operator.jcajce.JcaContentSignerBuilder
-dontwarn org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo
-dontwarn org.bouncycastle.pkcs.PKCSException
-dontwarn org.conscrypt.AllocatedBuffer
-dontwarn org.conscrypt.BufferAllocator
-dontwarn org.conscrypt.Conscrypt
-dontwarn org.conscrypt.HandshakeListener
-dontwarn org.eclipse.jetty.alpn.ALPN$ClientProvider
-dontwarn org.eclipse.jetty.alpn.ALPN$Provider
-dontwarn org.eclipse.jetty.alpn.ALPN$ServerProvider
-dontwarn org.eclipse.jetty.alpn.ALPN
-dontwarn org.eclipse.jetty.npn.NextProtoNego$ClientProvider
-dontwarn org.eclipse.jetty.npn.NextProtoNego$Provider
-dontwarn org.eclipse.jetty.npn.NextProtoNego$ServerProvider
-dontwarn org.eclipse.jetty.npn.NextProtoNego
-dontwarn org.hibernate.HibernateException
-dontwarn org.hibernate.Version
-dontwarn org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
-dontwarn org.hibernate.service.UnknownUnwrapTypeException
-dontwarn org.hibernate.service.spi.Configurable
-dontwarn org.hibernate.service.spi.Stoppable
-dontwarn org.jboss.marshalling.ByteInput
-dontwarn org.jboss.marshalling.ByteOutput
-dontwarn org.jboss.marshalling.Marshaller
-dontwarn org.jboss.marshalling.MarshallerFactory
-dontwarn org.jboss.marshalling.MarshallingConfiguration
-dontwarn org.jboss.marshalling.Unmarshaller
-dontwarn reactor.blockhound.BlockHound$Builder
-dontwarn reactor.blockhound.integration.BlockHoundIntegration
-dontwarn sun.security.x509.AlgorithmId
-dontwarn sun.security.x509.CertificateAlgorithmId
-dontwarn sun.security.x509.CertificateSerialNumber
-dontwarn sun.security.x509.CertificateSubjectName
-dontwarn sun.security.x509.CertificateValidity
-dontwarn sun.security.x509.CertificateVersion
-dontwarn sun.security.x509.CertificateX509Key
-dontwarn sun.security.x509.X500Name
-dontwarn sun.security.x509.X509CertImpl
-dontwarn sun.security.x509.X509CertInfo
-dontwarn com.codahale.metrics.Gauge
-dontwarn com.codahale.metrics.Histogram
-dontwarn com.codahale.metrics.Meter
-dontwarn com.codahale.metrics.Metric
-dontwarn com.codahale.metrics.MetricFilter
-dontwarn com.codahale.metrics.MetricRegistry
-dontwarn com.codahale.metrics.Snapshot
-dontwarn com.codahale.metrics.Timer
-dontwarn com.github.luben.zstd.ZstdInputStreamNoFinalizer
-dontwarn com.github.luben.zstd.util.Native
-dontwarn org.osgi.annotation.bundle.Export